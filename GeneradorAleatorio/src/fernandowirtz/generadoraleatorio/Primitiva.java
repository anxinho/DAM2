
package fernandowirtz.generadoraleatorio;

import java.util.Random;

public class Primitiva {
	
	private int[] nums=new int[6];
	
	public Primitiva(){
		generador();
	}
	
	private void generador(){
		Random r= new Random();
		int num;
		for(int i=0;i<nums.length;i++){
			do{
				num=r.nextInt(49)+1;
			}while(repetido(num));
			nums[i]=num;
		}
	}
	
	private boolean repetido(int n){
		for(int i=0;i<nums.length;i++){
			if(nums[i]==n)
				return true;
		}
		return false;
	}
	
	public String getExit(){
		String aux="";
		for(int i=0;i<nums.length;i++){
			if((i+1)==nums.length)
				aux+=nums[i];
			else
				aux+=nums[i]+"-";
		}
		return aux;
	}

	public int[] getNums() {
		return nums;
	}

}
