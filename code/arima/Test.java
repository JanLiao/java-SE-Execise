public class Test{
	public static void main(String[] args){
		//double data[]=new double[23];
		double[] data={29,111,13,71,74,30,55,159,35,134,57,51,73,39,102,283,136,52,85,48,37,102,85};
		double[] data2={0,0,0,0,0,0,0,0,0,0,0,0,0,3,222,576,449,371,488,385,143,351,407};
		double[] data3={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,48,12};
		double[] data1={46,59,104,144,167,117,194,148,138,109,65,162,205,182,424,165,192,262,94,112,196,222,169};
		double[] data4={0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,1};
		ARIMA arima=new ARIMA(data4);
		//ARIMA arima1=new ARIMA(data1);
		int []model=arima.getARIMAmodel();
		System.out.println();
		//int []model1=arima1.getARIMAmodel();
		for(int  k:model){
			System.out.print(" ="+k);
		}
		System.out.println("Predict value="+arima.aftDeal(arima.predictValue(model[0],model[1])));
		System.out.println("Predict error="+(arima.aftDeal(arima.predictValue(model[0],model[1]))-data[data.length-1])/data[data.length-1]*100+"%");
		System.out.println();
		// for(int  k:model1){
		// 	System.out.print(" ="+k);
		// }
		// System.out.println("Predict value="+arima.aftDeal(arima.predictValue(model1[0],model1[1])));
		// System.out.println("Predict error="+(arima.aftDeal(arima.predictValue(model1[0],model1[1]))-data1[data1.length-1])/data1[data1.length-1]*100+"%");
		// System.out.println("5555");
	}
}