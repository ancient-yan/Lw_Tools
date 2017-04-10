LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := my-ndk
LOCAL_SRC_FILES := my-ndk.c

include $(BUILD_SHARED_LIBRARY)
