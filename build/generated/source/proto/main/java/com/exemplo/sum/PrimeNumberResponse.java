// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sum/sum.proto

package com.exemplo.sum;

/**
 * Protobuf type {@code PrimeNumberResponse}
 */
public final class PrimeNumberResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:PrimeNumberResponse)
    PrimeNumberResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PrimeNumberResponse.newBuilder() to construct.
  private PrimeNumberResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PrimeNumberResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PrimeNumberResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.exemplo.sum.Sum.internal_static_PrimeNumberResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.exemplo.sum.Sum.internal_static_PrimeNumberResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.exemplo.sum.PrimeNumberResponse.class, com.exemplo.sum.PrimeNumberResponse.Builder.class);
  }

  public static final int PRIME_FACTOR_FIELD_NUMBER = 1;
  private int primeFactor_;
  /**
   * <code>int32 prime_factor = 1;</code>
   * @return The primeFactor.
   */
  @java.lang.Override
  public int getPrimeFactor() {
    return primeFactor_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (primeFactor_ != 0) {
      output.writeInt32(1, primeFactor_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (primeFactor_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, primeFactor_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.exemplo.sum.PrimeNumberResponse)) {
      return super.equals(obj);
    }
    com.exemplo.sum.PrimeNumberResponse other = (com.exemplo.sum.PrimeNumberResponse) obj;

    if (getPrimeFactor()
        != other.getPrimeFactor()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PRIME_FACTOR_FIELD_NUMBER;
    hash = (53 * hash) + getPrimeFactor();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.exemplo.sum.PrimeNumberResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.exemplo.sum.PrimeNumberResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.exemplo.sum.PrimeNumberResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code PrimeNumberResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:PrimeNumberResponse)
      com.exemplo.sum.PrimeNumberResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.exemplo.sum.Sum.internal_static_PrimeNumberResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.exemplo.sum.Sum.internal_static_PrimeNumberResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.exemplo.sum.PrimeNumberResponse.class, com.exemplo.sum.PrimeNumberResponse.Builder.class);
    }

    // Construct using com.exemplo.sum.PrimeNumberResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      primeFactor_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.exemplo.sum.Sum.internal_static_PrimeNumberResponse_descriptor;
    }

    @java.lang.Override
    public com.exemplo.sum.PrimeNumberResponse getDefaultInstanceForType() {
      return com.exemplo.sum.PrimeNumberResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.exemplo.sum.PrimeNumberResponse build() {
      com.exemplo.sum.PrimeNumberResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.exemplo.sum.PrimeNumberResponse buildPartial() {
      com.exemplo.sum.PrimeNumberResponse result = new com.exemplo.sum.PrimeNumberResponse(this);
      result.primeFactor_ = primeFactor_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.exemplo.sum.PrimeNumberResponse) {
        return mergeFrom((com.exemplo.sum.PrimeNumberResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.exemplo.sum.PrimeNumberResponse other) {
      if (other == com.exemplo.sum.PrimeNumberResponse.getDefaultInstance()) return this;
      if (other.getPrimeFactor() != 0) {
        setPrimeFactor(other.getPrimeFactor());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              primeFactor_ = input.readInt32();

              break;
            } // case 8
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private int primeFactor_ ;
    /**
     * <code>int32 prime_factor = 1;</code>
     * @return The primeFactor.
     */
    @java.lang.Override
    public int getPrimeFactor() {
      return primeFactor_;
    }
    /**
     * <code>int32 prime_factor = 1;</code>
     * @param value The primeFactor to set.
     * @return This builder for chaining.
     */
    public Builder setPrimeFactor(int value) {
      
      primeFactor_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 prime_factor = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrimeFactor() {
      
      primeFactor_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:PrimeNumberResponse)
  }

  // @@protoc_insertion_point(class_scope:PrimeNumberResponse)
  private static final com.exemplo.sum.PrimeNumberResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.exemplo.sum.PrimeNumberResponse();
  }

  public static com.exemplo.sum.PrimeNumberResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PrimeNumberResponse>
      PARSER = new com.google.protobuf.AbstractParser<PrimeNumberResponse>() {
    @java.lang.Override
    public PrimeNumberResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<PrimeNumberResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PrimeNumberResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.exemplo.sum.PrimeNumberResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

