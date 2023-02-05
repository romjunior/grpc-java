package com.exemplo.sum;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: sum/sum.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SumServiceGrpc {

  private SumServiceGrpc() {}

  public static final String SERVICE_NAME = "SumService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.exemplo.sum.SumRequest,
      com.exemplo.sum.SumResponse> getSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Sum",
      requestType = com.exemplo.sum.SumRequest.class,
      responseType = com.exemplo.sum.SumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.exemplo.sum.SumRequest,
      com.exemplo.sum.SumResponse> getSumMethod() {
    io.grpc.MethodDescriptor<com.exemplo.sum.SumRequest, com.exemplo.sum.SumResponse> getSumMethod;
    if ((getSumMethod = SumServiceGrpc.getSumMethod) == null) {
      synchronized (SumServiceGrpc.class) {
        if ((getSumMethod = SumServiceGrpc.getSumMethod) == null) {
          SumServiceGrpc.getSumMethod = getSumMethod =
              io.grpc.MethodDescriptor.<com.exemplo.sum.SumRequest, com.exemplo.sum.SumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Sum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.SumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SumServiceMethodDescriptorSupplier("Sum"))
              .build();
        }
      }
    }
    return getSumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.exemplo.sum.PrimeNumberRequest,
      com.exemplo.sum.PrimeNumberResponse> getPrimeNumberDecompositionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PrimeNumberDecomposition",
      requestType = com.exemplo.sum.PrimeNumberRequest.class,
      responseType = com.exemplo.sum.PrimeNumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.exemplo.sum.PrimeNumberRequest,
      com.exemplo.sum.PrimeNumberResponse> getPrimeNumberDecompositionMethod() {
    io.grpc.MethodDescriptor<com.exemplo.sum.PrimeNumberRequest, com.exemplo.sum.PrimeNumberResponse> getPrimeNumberDecompositionMethod;
    if ((getPrimeNumberDecompositionMethod = SumServiceGrpc.getPrimeNumberDecompositionMethod) == null) {
      synchronized (SumServiceGrpc.class) {
        if ((getPrimeNumberDecompositionMethod = SumServiceGrpc.getPrimeNumberDecompositionMethod) == null) {
          SumServiceGrpc.getPrimeNumberDecompositionMethod = getPrimeNumberDecompositionMethod =
              io.grpc.MethodDescriptor.<com.exemplo.sum.PrimeNumberRequest, com.exemplo.sum.PrimeNumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PrimeNumberDecomposition"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.PrimeNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.PrimeNumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SumServiceMethodDescriptorSupplier("PrimeNumberDecomposition"))
              .build();
        }
      }
    }
    return getPrimeNumberDecompositionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.exemplo.sum.AverageRequest,
      com.exemplo.sum.AverageResponse> getAverageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Average",
      requestType = com.exemplo.sum.AverageRequest.class,
      responseType = com.exemplo.sum.AverageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.exemplo.sum.AverageRequest,
      com.exemplo.sum.AverageResponse> getAverageMethod() {
    io.grpc.MethodDescriptor<com.exemplo.sum.AverageRequest, com.exemplo.sum.AverageResponse> getAverageMethod;
    if ((getAverageMethod = SumServiceGrpc.getAverageMethod) == null) {
      synchronized (SumServiceGrpc.class) {
        if ((getAverageMethod = SumServiceGrpc.getAverageMethod) == null) {
          SumServiceGrpc.getAverageMethod = getAverageMethod =
              io.grpc.MethodDescriptor.<com.exemplo.sum.AverageRequest, com.exemplo.sum.AverageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Average"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.AverageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.AverageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SumServiceMethodDescriptorSupplier("Average"))
              .build();
        }
      }
    }
    return getAverageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.exemplo.sum.MaximumRequest,
      com.exemplo.sum.MaximumResponse> getMaximumNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MaximumNumber",
      requestType = com.exemplo.sum.MaximumRequest.class,
      responseType = com.exemplo.sum.MaximumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.exemplo.sum.MaximumRequest,
      com.exemplo.sum.MaximumResponse> getMaximumNumberMethod() {
    io.grpc.MethodDescriptor<com.exemplo.sum.MaximumRequest, com.exemplo.sum.MaximumResponse> getMaximumNumberMethod;
    if ((getMaximumNumberMethod = SumServiceGrpc.getMaximumNumberMethod) == null) {
      synchronized (SumServiceGrpc.class) {
        if ((getMaximumNumberMethod = SumServiceGrpc.getMaximumNumberMethod) == null) {
          SumServiceGrpc.getMaximumNumberMethod = getMaximumNumberMethod =
              io.grpc.MethodDescriptor.<com.exemplo.sum.MaximumRequest, com.exemplo.sum.MaximumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MaximumNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.MaximumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.MaximumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SumServiceMethodDescriptorSupplier("MaximumNumber"))
              .build();
        }
      }
    }
    return getMaximumNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.exemplo.sum.SquareRootRequest,
      com.exemplo.sum.SquareRootResponse> getSquareRootMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SquareRoot",
      requestType = com.exemplo.sum.SquareRootRequest.class,
      responseType = com.exemplo.sum.SquareRootResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.exemplo.sum.SquareRootRequest,
      com.exemplo.sum.SquareRootResponse> getSquareRootMethod() {
    io.grpc.MethodDescriptor<com.exemplo.sum.SquareRootRequest, com.exemplo.sum.SquareRootResponse> getSquareRootMethod;
    if ((getSquareRootMethod = SumServiceGrpc.getSquareRootMethod) == null) {
      synchronized (SumServiceGrpc.class) {
        if ((getSquareRootMethod = SumServiceGrpc.getSquareRootMethod) == null) {
          SumServiceGrpc.getSquareRootMethod = getSquareRootMethod =
              io.grpc.MethodDescriptor.<com.exemplo.sum.SquareRootRequest, com.exemplo.sum.SquareRootResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SquareRoot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.SquareRootRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.exemplo.sum.SquareRootResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SumServiceMethodDescriptorSupplier("SquareRoot"))
              .build();
        }
      }
    }
    return getSquareRootMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SumServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SumServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SumServiceStub>() {
        @java.lang.Override
        public SumServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SumServiceStub(channel, callOptions);
        }
      };
    return SumServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SumServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SumServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SumServiceBlockingStub>() {
        @java.lang.Override
        public SumServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SumServiceBlockingStub(channel, callOptions);
        }
      };
    return SumServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SumServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SumServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SumServiceFutureStub>() {
        @java.lang.Override
        public SumServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SumServiceFutureStub(channel, callOptions);
        }
      };
    return SumServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SumServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sum(com.exemplo.sum.SumRequest request,
        io.grpc.stub.StreamObserver<com.exemplo.sum.SumResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSumMethod(), responseObserver);
    }

    /**
     */
    public void primeNumberDecomposition(com.exemplo.sum.PrimeNumberRequest request,
        io.grpc.stub.StreamObserver<com.exemplo.sum.PrimeNumberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrimeNumberDecompositionMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.exemplo.sum.AverageRequest> average(
        io.grpc.stub.StreamObserver<com.exemplo.sum.AverageResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAverageMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.exemplo.sum.MaximumRequest> maximumNumber(
        io.grpc.stub.StreamObserver<com.exemplo.sum.MaximumResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMaximumNumberMethod(), responseObserver);
    }

    /**
     */
    public void squareRoot(com.exemplo.sum.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.exemplo.sum.SquareRootResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSquareRootMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSumMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.exemplo.sum.SumRequest,
                com.exemplo.sum.SumResponse>(
                  this, METHODID_SUM)))
          .addMethod(
            getPrimeNumberDecompositionMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.exemplo.sum.PrimeNumberRequest,
                com.exemplo.sum.PrimeNumberResponse>(
                  this, METHODID_PRIME_NUMBER_DECOMPOSITION)))
          .addMethod(
            getAverageMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.exemplo.sum.AverageRequest,
                com.exemplo.sum.AverageResponse>(
                  this, METHODID_AVERAGE)))
          .addMethod(
            getMaximumNumberMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.exemplo.sum.MaximumRequest,
                com.exemplo.sum.MaximumResponse>(
                  this, METHODID_MAXIMUM_NUMBER)))
          .addMethod(
            getSquareRootMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.exemplo.sum.SquareRootRequest,
                com.exemplo.sum.SquareRootResponse>(
                  this, METHODID_SQUARE_ROOT)))
          .build();
    }
  }

  /**
   */
  public static final class SumServiceStub extends io.grpc.stub.AbstractAsyncStub<SumServiceStub> {
    private SumServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SumServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SumServiceStub(channel, callOptions);
    }

    /**
     */
    public void sum(com.exemplo.sum.SumRequest request,
        io.grpc.stub.StreamObserver<com.exemplo.sum.SumResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void primeNumberDecomposition(com.exemplo.sum.PrimeNumberRequest request,
        io.grpc.stub.StreamObserver<com.exemplo.sum.PrimeNumberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getPrimeNumberDecompositionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.exemplo.sum.AverageRequest> average(
        io.grpc.stub.StreamObserver<com.exemplo.sum.AverageResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getAverageMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.exemplo.sum.MaximumRequest> maximumNumber(
        io.grpc.stub.StreamObserver<com.exemplo.sum.MaximumResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMaximumNumberMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void squareRoot(com.exemplo.sum.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.exemplo.sum.SquareRootResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SumServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SumServiceBlockingStub> {
    private SumServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SumServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SumServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.exemplo.sum.SumResponse sum(com.exemplo.sum.SumRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSumMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.exemplo.sum.PrimeNumberResponse> primeNumberDecomposition(
        com.exemplo.sum.PrimeNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getPrimeNumberDecompositionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.exemplo.sum.SquareRootResponse squareRoot(com.exemplo.sum.SquareRootRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSquareRootMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SumServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SumServiceFutureStub> {
    private SumServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SumServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SumServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.exemplo.sum.SumResponse> sum(
        com.exemplo.sum.SumRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.exemplo.sum.SquareRootResponse> squareRoot(
        com.exemplo.sum.SquareRootRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUM = 0;
  private static final int METHODID_PRIME_NUMBER_DECOMPOSITION = 1;
  private static final int METHODID_SQUARE_ROOT = 2;
  private static final int METHODID_AVERAGE = 3;
  private static final int METHODID_MAXIMUM_NUMBER = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SumServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SumServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUM:
          serviceImpl.sum((com.exemplo.sum.SumRequest) request,
              (io.grpc.stub.StreamObserver<com.exemplo.sum.SumResponse>) responseObserver);
          break;
        case METHODID_PRIME_NUMBER_DECOMPOSITION:
          serviceImpl.primeNumberDecomposition((com.exemplo.sum.PrimeNumberRequest) request,
              (io.grpc.stub.StreamObserver<com.exemplo.sum.PrimeNumberResponse>) responseObserver);
          break;
        case METHODID_SQUARE_ROOT:
          serviceImpl.squareRoot((com.exemplo.sum.SquareRootRequest) request,
              (io.grpc.stub.StreamObserver<com.exemplo.sum.SquareRootResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AVERAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.average(
              (io.grpc.stub.StreamObserver<com.exemplo.sum.AverageResponse>) responseObserver);
        case METHODID_MAXIMUM_NUMBER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.maximumNumber(
              (io.grpc.stub.StreamObserver<com.exemplo.sum.MaximumResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SumServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SumServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.exemplo.sum.Sum.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SumService");
    }
  }

  private static final class SumServiceFileDescriptorSupplier
      extends SumServiceBaseDescriptorSupplier {
    SumServiceFileDescriptorSupplier() {}
  }

  private static final class SumServiceMethodDescriptorSupplier
      extends SumServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SumServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SumServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SumServiceFileDescriptorSupplier())
              .addMethod(getSumMethod())
              .addMethod(getPrimeNumberDecompositionMethod())
              .addMethod(getAverageMethod())
              .addMethod(getMaximumNumberMethod())
              .addMethod(getSquareRootMethod())
              .build();
        }
      }
    }
    return result;
  }
}
