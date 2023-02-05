package com.exemplo.blog.server;

import com.exemplo.blog.Blog;
import com.exemplo.blog.BlogServiceGrpc;
import com.exemplo.blog.DeleteBlogEntity;
import com.exemplo.blog.ListBlogRequest;
import com.exemplo.blog.ReadBlogRequest;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.bson.Document;
import org.bson.types.ObjectId;

public class BlogServiceImpl extends BlogServiceGrpc.BlogServiceImplBase {

    private MongoClient mongoClient = MongoClients.create("mongodb://root:example@localhost:27017");
    private MongoDatabase database = mongoClient.getDatabase("grpc-java");
    private MongoCollection<Document> collection = database.getCollection("blog");

    @Override
    public void createBlog(Blog request, StreamObserver<Blog> responseObserver) {

        final var doc = new Document("author_id", request.getAuthorId())
                .append("title", request.getTitle())
                        .append("content", request.getContent());

        collection.insertOne(doc);

        final var id = doc.getObjectId("_id").toString();

        responseObserver.onNext(request
                .toBuilder()
                .setId(id)
                .build()
        );

        responseObserver.onCompleted();
    }

    @Override
    public void readBlog(ReadBlogRequest request, StreamObserver<Blog> responseObserver) {
        final var result = collection
                .find(Filters
                        .eq("_id", new ObjectId(request.getBlogId())))
                .first();

        if(result == null) {
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("o blog com o id correspondente não foi encontrado")
                    .asRuntimeException()
            );
        } else {
            final var blog = Blog.newBuilder()
                    .setAuthorId(result.getString("author_id"))
                    .setTitle(result.getString("title"))
                    .setContent(result.getString("content"))
                    .setId(result.getObjectId("_id").toString())
                    .build();
            responseObserver.onNext(blog);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateBlog(Blog request, StreamObserver<Blog> responseObserver) {
        final var search = collection
                .find(Filters
                        .eq("_id", new ObjectId(request.getId())))
                .first();

        if(search == null) {
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("o blog com o id correspondente não foi encontrado")
                    .asRuntimeException()
            );
        } else {

            final var doc = new Document("author_id", request.getAuthorId())
                    .append("title", request.getTitle())
                    .append("content", request.getContent());

            collection.replaceOne(Filters.eq("_id", search.getObjectId("_id")), doc);

            final var blog = Blog.newBuilder()
                    .setAuthorId(doc.getString("author_id"))
                    .setTitle(doc.getString("title"))
                    .setContent(doc.getString("content"))
                    .setId(search.getObjectId("_id").toString())
                    .build();

            responseObserver.onNext(blog);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteBlog(DeleteBlogEntity request, StreamObserver<DeleteBlogEntity> responseObserver) {

        DeleteResult result = null;

        try {
            result = collection.deleteOne(Filters.eq("_id", new ObjectId(request.getBlogId())));

            if(result.getDeletedCount() == 0) {
                throw new RuntimeException("id não encontrado");
            }

        } catch (Exception ex) {
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("o blog com o id correspondente não foi encontrado")
                    .asRuntimeException());
            return;
        }

        responseObserver.onNext(DeleteBlogEntity.newBuilder()
                        .setBlogId(request.getBlogId())
                .build());

        responseObserver.onCompleted();
    }

    @Override
    public void listBlog(ListBlogRequest request, StreamObserver<Blog> responseObserver) {
        collection.find()
                .forEach(doc -> responseObserver.onNext(Blog.newBuilder()
                        .setAuthorId(doc.getString("author_id"))
                        .setTitle(doc.getString("title"))
                        .setContent(doc.getString("content"))
                        .setId(doc.getObjectId("_id").toString())
                        .build()));

        responseObserver.onCompleted();
    }
}
