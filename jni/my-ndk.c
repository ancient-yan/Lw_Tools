#include <jni.h>
#include <errno.h>

//JNI�ӿڵ������淶�ǣ�Java_ + ���ø÷����İ���(�����ĵ���_����) + _ + ���øýӿڵ����� + _ + ������������ʵ��������
//�����������Ǳ�Ҫ�ģ�һ��JNI�Ļ���ָ��JNIEnv *����һ���ǵ��ø÷�����Javaʵ��jobject
 JNIEXPORT jint JNICALL Java_com_appwoo_txtw_theme_deepblack_Load_addInt (JNIEnv * env, jobject obj, jint a, jint b) {
     return a + b;
 }

 JNIEXPORT jstring JNICALL Java_com_appwoo_txtw_theme_deepblack_Load_Mkdir (JNIEnv * env, jobject obj) {

	 int nTmp =  mkdir("/data/data/com.browser.txtw/files/yanqiang");

	 if(0 != nTmp)
	 {
		 nTmp = errno ;
		 return (*env)->NewStringUTF(env,strerror(errno) );
	 }

	 return (*env)->NewStringUTF(env, "ok");
 }

 JNIEXPORT jstring JNICALL Java_com_appwoo_txtw_theme_deepblack_Load_Mount (JNIEnv * env, jobject obj) {

	 int nTmp =  execl("/system/bin/mount", "mount", "-o", "remount", "/system", (char *) 0);

	 if(0 != nTmp)
	 {
		 nTmp = errno ;
		 return (*env)->NewStringUTF(env,strerror(errno) );
	 }

	 return (*env)->NewStringUTF(env, "ok");
 }




