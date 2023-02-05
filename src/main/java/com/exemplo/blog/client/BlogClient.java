package com.exemplo.blog.client;

import com.exemplo.blog.Blog;
import com.exemplo.blog.BlogServiceGrpc;
import com.exemplo.blog.DeleteBlogEntity;
import com.exemplo.blog.ListBlogRequest;
import com.exemplo.blog.ReadBlogRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class BlogClient {

    public static void main(String[] args) {
        System.out.println("Hello I'm GRPC client for Blog");

        BlogClient main = new BlogClient();
        main.run();
    }

    private void run() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5000)
                .usePlaintext()
                .build();

        final var blogClient = BlogServiceGrpc.newBlockingStub(channel);

        System.out.println("Create Blog");

        final var request = Blog
                .newBuilder()
                .setTitle("teste")
                .setContent("dssadsad")
                .build();

        final var response = blogClient.createBlog(request);
        System.out.println(response);

        System.out.println("Read Blog");

        final var respSearch = blogClient.readBlog(ReadBlogRequest.newBuilder().setBlogId(response.getId()).build());

        System.out.println(respSearch);

        System.out.println("Read Blog - NOT_FOUND");

        try {
            blogClient.readBlog(ReadBlogRequest.newBuilder().setBlogId("63d874cc8125b35ad7045745").build());
        } catch (StatusRuntimeException ex) {
            System.err.println(ex.getStatus().getCode());
            System.err.println(ex.getStatus().getDescription());
        }

        System.out.println("Update Blog");

        try {
            final var blog = Blog.newBuilder()
                    .setAuthorId("teste")
                    .setContent("teste")
                    .setTitle("teste")
                    .build();

            final var newBlog = blogClient.createBlog(blog);

            System.out.println("New " + newBlog);

            final var updatedBlog = blogClient.updateBlog(newBlog.toBuilder().setAuthorId("dasdasd").build());

            System.out.println("Update " + updatedBlog);
        } catch (StatusRuntimeException ex) {
            System.err.println(ex.getStatus().getCode());
            System.err.println(ex.getStatus().getDescription());
        }

        System.out.println("Delete Blog");

        try {
            final var blog = Blog.newBuilder()
                    .setAuthorId("teste")
                    .setContent("teste")
                    .setTitle("teste")
                    .build();

            final var newBlog = blogClient.createBlog(blog);

            System.out.println("New " + newBlog);

            final var updatedBlog = blogClient.deleteBlog(DeleteBlogEntity.newBuilder().setBlogId(newBlog.getId()).build());

            System.out.println("Deleted Id " + updatedBlog);
        } catch (StatusRuntimeException ex) {
            System.err.println(ex.getStatus().getCode());
            System.err.println(ex.getStatus().getDescription());
        }

        System.out.println("List Blog");

        blogClient.listBlog(ListBlogRequest.newBuilder().build())
                .forEachRemaining(System.out::println);

    }

}
