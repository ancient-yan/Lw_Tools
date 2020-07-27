package android.app;

interface IromMDM
{
    boolean setFunction(in ContentValues cv, in List<String> listIn, out List<String> listOut);
    ContentValues getFunction(in ContentValues cv, in List<String> listIn, out List<String> listOut);
}