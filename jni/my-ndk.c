#include <jni.h>

//JNI�ӿڵ������淶�ǣ�Java_ + ���ø÷����İ���(�����ĵ���_����) + _ + ���øýӿڵ����� + _ + ������������ʵ��������
//�����������Ǳ�Ҫ�ģ�һ��JNI�Ļ���ָ��JNIEnv *����һ���ǵ��ø÷�����Javaʵ��jobject
 JNIEXPORT jint JNICALL Java_com_appwoo_txtw_theme_deepblack_Load_addInt (JNIEnv * env, jobject obj, jint a, jint b) {
     return a + b;
 }

