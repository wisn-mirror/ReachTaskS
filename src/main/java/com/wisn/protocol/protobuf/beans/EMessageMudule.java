// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: EMessage.proto

package com.wisn.protocol.protobuf.beans;

public final class EMessageMudule {
  private EMessageMudule() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface EMessageOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // required int64 messageid = 1;
    boolean hasMessageid();
    long getMessageid();
    
    // required int64 fromuserid = 2;
    boolean hasFromuserid();
    long getFromuserid();
    
    // required int64 targetuserid = 3;
    boolean hasTargetuserid();
    long getTargetuserid();
    
    // required int32 messagetype = 4;
    boolean hasMessagetype();
    int getMessagetype();
    
    // required int32 status = 5;
    boolean hasStatus();
    int getStatus();
    
    // required string content = 6;
    boolean hasContent();
    String getContent();
    
    // required int64 createtime = 7;
    boolean hasCreatetime();
    long getCreatetime();
    
    // required int64 receivetime = 8;
    boolean hasReceivetime();
    long getReceivetime();
  }
  public static final class EMessage extends
      com.google.protobuf.GeneratedMessage
      implements EMessageOrBuilder {
    public String toMString() {
      return "EMessage{" +
              "messageid_=" + messageid_ +
              ", fromuserid_=" + fromuserid_ +
              ", targetuserid_=" + targetuserid_ +
              ", messagetype_=" + messagetype_ +
              ", status_=" + status_ +
              ", content_=" + content_ +
              ", createtime_=" + createtime_ +
              ", receivetime_=" + receivetime_ +
              '}';
    }

    // Use EMessage.newBuilder() to construct.
    private EMessage(Builder builder) {
      super(builder);
    }
    private EMessage(boolean noInit) {}
    
    private static final EMessage defaultInstance;
    public static EMessage getDefaultInstance() {
      return defaultInstance;
    }
    
    public EMessage getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.wisn.protocol.protobuf.beans.EMessageMudule.internal_static_EMessage_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.wisn.protocol.protobuf.beans.EMessageMudule.internal_static_EMessage_fieldAccessorTable;
    }
    
    private int bitField0_;
    // required int64 messageid = 1;
    public static final int MESSAGEID_FIELD_NUMBER = 1;
    private long messageid_;
    public boolean hasMessageid() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public long getMessageid() {
      return messageid_;
    }
    
    // required int64 fromuserid = 2;
    public static final int FROMUSERID_FIELD_NUMBER = 2;
    private long fromuserid_;
    public boolean hasFromuserid() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    public long getFromuserid() {
      return fromuserid_;
    }
    
    // required int64 targetuserid = 3;
    public static final int TARGETUSERID_FIELD_NUMBER = 3;
    private long targetuserid_;
    public boolean hasTargetuserid() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    public long getTargetuserid() {
      return targetuserid_;
    }
    
    // required int32 messagetype = 4;
    public static final int MESSAGETYPE_FIELD_NUMBER = 4;
    private int messagetype_;
    public boolean hasMessagetype() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    public int getMessagetype() {
      return messagetype_;
    }
    
    // required int32 status = 5;
    public static final int STATUS_FIELD_NUMBER = 5;
    private int status_;
    public boolean hasStatus() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    public int getStatus() {
      return status_;
    }
    
    // required string content = 6;
    public static final int CONTENT_FIELD_NUMBER = 6;
    private java.lang.Object content_;
    public boolean hasContent() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    public String getContent() {
      java.lang.Object ref = content_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
          content_ = s;
        }
        return s;
      }
    }
    private com.google.protobuf.ByteString getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    
    // required int64 createtime = 7;
    public static final int CREATETIME_FIELD_NUMBER = 7;
    private long createtime_;
    public boolean hasCreatetime() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    public long getCreatetime() {
      return createtime_;
    }
    
    // required int64 receivetime = 8;
    public static final int RECEIVETIME_FIELD_NUMBER = 8;
    private long receivetime_;
    public boolean hasReceivetime() {
      return ((bitField0_ & 0x00000080) == 0x00000080);
    }
    public long getReceivetime() {
      return receivetime_;
    }
    
    private void initFields() {
      messageid_ = 0L;
      fromuserid_ = 0L;
      targetuserid_ = 0L;
      messagetype_ = 0;
      status_ = 0;
      content_ = "";
      createtime_ = 0L;
      receivetime_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      if (!hasMessageid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasFromuserid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasTargetuserid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasMessagetype()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasStatus()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasContent()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasCreatetime()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasReceivetime()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt64(1, messageid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt64(2, fromuserid_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt64(3, targetuserid_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt32(4, messagetype_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeInt32(5, status_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        output.writeBytes(6, getContentBytes());
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        output.writeInt64(7, createtime_);
      }
      if (((bitField0_ & 0x00000080) == 0x00000080)) {
        output.writeInt64(8, receivetime_);
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, messageid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, fromuserid_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(3, targetuserid_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, messagetype_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, status_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(6, getContentBytes());
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(7, createtime_);
      }
      if (((bitField0_ & 0x00000080) == 0x00000080)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(8, receivetime_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.wisn.protocol.protobuf.beans.EMessageMudule.EMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.wisn.protocol.protobuf.beans.EMessageMudule.internal_static_EMessage_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.wisn.protocol.protobuf.beans.EMessageMudule.internal_static_EMessage_fieldAccessorTable;
      }
      
      // Construct using com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        messageid_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        fromuserid_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        targetuserid_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000004);
        messagetype_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        status_ = 0;
        bitField0_ = (bitField0_ & ~0x00000010);
        content_ = "";
        bitField0_ = (bitField0_ & ~0x00000020);
        createtime_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000040);
        receivetime_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000080);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage.getDescriptor();
      }
      
      public com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage getDefaultInstanceForType() {
        return com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage.getDefaultInstance();
      }
      
      public com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage build() {
        com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage buildPartial() {
        com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage result = new com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.messageid_ = messageid_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.fromuserid_ = fromuserid_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.targetuserid_ = targetuserid_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.messagetype_ = messagetype_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.status_ = status_;
        if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
          to_bitField0_ |= 0x00000020;
        }
        result.content_ = content_;
        if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
          to_bitField0_ |= 0x00000040;
        }
        result.createtime_ = createtime_;
        if (((from_bitField0_ & 0x00000080) == 0x00000080)) {
          to_bitField0_ |= 0x00000080;
        }
        result.receivetime_ = receivetime_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage) {
          return mergeFrom((com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage other) {
        if (other == com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage.getDefaultInstance()) return this;
        if (other.hasMessageid()) {
          setMessageid(other.getMessageid());
        }
        if (other.hasFromuserid()) {
          setFromuserid(other.getFromuserid());
        }
        if (other.hasTargetuserid()) {
          setTargetuserid(other.getTargetuserid());
        }
        if (other.hasMessagetype()) {
          setMessagetype(other.getMessagetype());
        }
        if (other.hasStatus()) {
          setStatus(other.getStatus());
        }
        if (other.hasContent()) {
          setContent(other.getContent());
        }
        if (other.hasCreatetime()) {
          setCreatetime(other.getCreatetime());
        }
        if (other.hasReceivetime()) {
          setReceivetime(other.getReceivetime());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        if (!hasMessageid()) {
          
          return false;
        }
        if (!hasFromuserid()) {
          
          return false;
        }
        if (!hasTargetuserid()) {
          
          return false;
        }
        if (!hasMessagetype()) {
          
          return false;
        }
        if (!hasStatus()) {
          
          return false;
        }
        if (!hasContent()) {
          
          return false;
        }
        if (!hasCreatetime()) {
          
          return false;
        }
        if (!hasReceivetime()) {
          
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              messageid_ = input.readInt64();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              fromuserid_ = input.readInt64();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              targetuserid_ = input.readInt64();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              messagetype_ = input.readInt32();
              break;
            }
            case 40: {
              bitField0_ |= 0x00000010;
              status_ = input.readInt32();
              break;
            }
            case 50: {
              bitField0_ |= 0x00000020;
              content_ = input.readBytes();
              break;
            }
            case 56: {
              bitField0_ |= 0x00000040;
              createtime_ = input.readInt64();
              break;
            }
            case 64: {
              bitField0_ |= 0x00000080;
              receivetime_ = input.readInt64();
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // required int64 messageid = 1;
      private long messageid_ ;
      public boolean hasMessageid() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public long getMessageid() {
        return messageid_;
      }
      public Builder setMessageid(long value) {
        bitField0_ |= 0x00000001;
        messageid_ = value;
        onChanged();
        return this;
      }
      public Builder clearMessageid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        messageid_ = 0L;
        onChanged();
        return this;
      }
      
      // required int64 fromuserid = 2;
      private long fromuserid_ ;
      public boolean hasFromuserid() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      public long getFromuserid() {
        return fromuserid_;
      }
      public Builder setFromuserid(long value) {
        bitField0_ |= 0x00000002;
        fromuserid_ = value;
        onChanged();
        return this;
      }
      public Builder clearFromuserid() {
        bitField0_ = (bitField0_ & ~0x00000002);
        fromuserid_ = 0L;
        onChanged();
        return this;
      }
      
      // required int64 targetuserid = 3;
      private long targetuserid_ ;
      public boolean hasTargetuserid() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      public long getTargetuserid() {
        return targetuserid_;
      }
      public Builder setTargetuserid(long value) {
        bitField0_ |= 0x00000004;
        targetuserid_ = value;
        onChanged();
        return this;
      }
      public Builder clearTargetuserid() {
        bitField0_ = (bitField0_ & ~0x00000004);
        targetuserid_ = 0L;
        onChanged();
        return this;
      }
      
      // required int32 messagetype = 4;
      private int messagetype_ ;
      public boolean hasMessagetype() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      public int getMessagetype() {
        return messagetype_;
      }
      public Builder setMessagetype(int value) {
        bitField0_ |= 0x00000008;
        messagetype_ = value;
        onChanged();
        return this;
      }
      public Builder clearMessagetype() {
        bitField0_ = (bitField0_ & ~0x00000008);
        messagetype_ = 0;
        onChanged();
        return this;
      }
      
      // required int32 status = 5;
      private int status_ ;
      public boolean hasStatus() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      public int getStatus() {
        return status_;
      }
      public Builder setStatus(int value) {
        bitField0_ |= 0x00000010;
        status_ = value;
        onChanged();
        return this;
      }
      public Builder clearStatus() {
        bitField0_ = (bitField0_ & ~0x00000010);
        status_ = 0;
        onChanged();
        return this;
      }
      
      // required string content = 6;
      private java.lang.Object content_ = "";
      public boolean hasContent() {
        return ((bitField0_ & 0x00000020) == 0x00000020);
      }
      public String getContent() {
        java.lang.Object ref = content_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
          content_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      public Builder setContent(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
        content_ = value;
        onChanged();
        return this;
      }
      public Builder clearContent() {
        bitField0_ = (bitField0_ & ~0x00000020);
        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      void setContent(com.google.protobuf.ByteString value) {
        bitField0_ |= 0x00000020;
        content_ = value;
        onChanged();
      }
      
      // required int64 createtime = 7;
      private long createtime_ ;
      public boolean hasCreatetime() {
        return ((bitField0_ & 0x00000040) == 0x00000040);
      }
      public long getCreatetime() {
        return createtime_;
      }
      public Builder setCreatetime(long value) {
        bitField0_ |= 0x00000040;
        createtime_ = value;
        onChanged();
        return this;
      }
      public Builder clearCreatetime() {
        bitField0_ = (bitField0_ & ~0x00000040);
        createtime_ = 0L;
        onChanged();
        return this;
      }
      
      // required int64 receivetime = 8;
      private long receivetime_ ;
      public boolean hasReceivetime() {
        return ((bitField0_ & 0x00000080) == 0x00000080);
      }
      public long getReceivetime() {
        return receivetime_;
      }
      public Builder setReceivetime(long value) {
        bitField0_ |= 0x00000080;
        receivetime_ = value;
        onChanged();
        return this;
      }
      public Builder clearReceivetime() {
        bitField0_ = (bitField0_ & ~0x00000080);
        receivetime_ = 0L;
        onChanged();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:EMessage)
    }
    
    static {
      defaultInstance = new EMessage(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:EMessage)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_EMessage_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_EMessage_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016EMessage.proto\"\246\001\n\010EMessage\022\021\n\tmessage" +
      "id\030\001 \002(\003\022\022\n\nfromuserid\030\002 \002(\003\022\024\n\014targetus" +
      "erid\030\003 \002(\003\022\023\n\013messagetype\030\004 \002(\005\022\016\n\006statu" +
      "s\030\005 \002(\005\022\017\n\007content\030\006 \002(\t\022\022\n\ncreatetime\030\007" +
      " \002(\003\022\023\n\013receivetime\030\010 \002(\003B2\n com.wisn.pr" +
      "otocol.protobuf.beansB\016EMessageMudule"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_EMessage_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_EMessage_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_EMessage_descriptor,
              new java.lang.String[] { "Messageid", "Fromuserid", "Targetuserid", "Messagetype", "Status", "Content", "Createtime", "Receivetime", },
              com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage.class,
              com.wisn.protocol.protobuf.beans.EMessageMudule.EMessage.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}
