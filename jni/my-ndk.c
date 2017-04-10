#include <jni.h>

//JNI接口的命名规范是：Java_ + 调用该方法的包名(包名的点用_代替) + _ + 调用该接口的类名 + _ + 方法名，对于实例方法，
//有两个参数是必要的，一个JNI的环境指针JNIEnv *，另一个是调用该方法的Java实例jobject
 JNIEXPORT jint JNICALL Java_com_appwoo_txtw_theme_deepblack_Load_addInt (JNIEnv * env, jobject obj, jint a, jint b) {
     return a + b;
 }

