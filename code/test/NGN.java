import java.io.*;
import Jama.Matrix;
public class NGN{
	Matrix f_k, f_k1, deltaF;
    Matrix theta_k, theta_k1, hTheta;
    Matrix t_k, t_k1, hT;
    Matrix hTilde;
    Matrix JTilde_k, JTilde_k1;
    Matrix fHat_t_k, fHat_t_k1;
    Matrix JHat_k, JHat_k1;

    public NGN(int fs, int dof) {
		JHat_k1 = new Matrix(dof, fs);
	//JHat_k1 = new Matrix(fs, dof);
	//	JHat_k1 = JHat_k1.identity(dof, fs);
	JHat_k1.print(2, 1);
    }
}