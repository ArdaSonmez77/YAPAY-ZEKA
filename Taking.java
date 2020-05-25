import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class Taking {
	static Random rnd= new Random();
	public static void main(String[] args) {


		//Needer[] tank= new Needer[9];
		int[][] numbers = new int[14][2];
		numbers=designer();
		
		
		ArrayList<Integer> stok=new ArrayList<>();
		ArrayList<Integer> thrower= new ArrayList<>();
		ArrayList<Integer> grp2= new ArrayList<>();
		ArrayList<Integer> grp3= new ArrayList<>();

		for(int a=1; a<107; a++) {

			if(a%13==0) {
				stok.add(13);
			}else if(a/13==8 && a%13!=0) {
				stok.add(0);

			}else {
				stok.add(a%13);
			}


		}
		//System.out.println(stok);
		/*	for(int m=0; m<stok.size(); m++) {
		if(m%13==0) {
			System.out.println();
		}
		System.out.print(stok.get(m)+" ");
	}*/
		System.out.println();
		ArrayList<Integer> p1=new ArrayList<>();
		ArrayList<Integer> dblGrp=new ArrayList<>();
		ArrayList<Integer> YandanAl=new ArrayList<>();
		ArrayList<Integer> YeniAl= new ArrayList<>();
		for(int t=0; t<17.; t++) {
			int stone= rnd.nextInt(stok.size());
			p1.add(stok.get(stone));
			stok.remove(stone);
		}
		for(int a: p1) {
			System.out.print(a+" ");
		}
		p1.sort(null);
		System.out.println("Sorted array:");
		System.out.println(p1);
		//Foreach
		//Taslarý sayiyorum
		for(int monk: p1) {
			switch(monk) {
			case 1: 
				numbers[monk][1]++;
				break;

			case 2: 
				numbers[monk][1]++;
				break;
			case 3: 
				numbers[monk][1]++;
				break;
			case 4: 
				numbers[monk][1]++;
				break;
			case 5: 
				numbers[monk][1]++;	
				break;
			case 6: 
				numbers[monk][1]++;
				break;
			case 7: 
				numbers[monk][1]++;
				break;
			case 8: 
				numbers[monk][1]++;
				break;
			case 9: 
				numbers[monk][1]++;
				break;
			case 10: 
				numbers[monk][1]++;
				break;
			case 11: 
				numbers[monk][1]++;
				break;
			case 12: 
				numbers[monk][1]++;
				break;
			case 13: 
				numbers[monk][1]++;
				break;
			default:
				numbers[monk][1]++;
				break;

			}
		}
		int a=0;
		//Forloop ta hangi tastan kaç tane var diye bakiyorum
		for(int m=0; m<numbers.length; m++) {
			int counter=numbers[m][1];
			a++;
			switch(counter) {

			case 0:
				break;
			case 1:
				System.out.println(numbers[m][0]+" have only one");
				break;
			case 2:
				System.out.println(numbers[m][0]+" have 2 elements");
				break;
			default:
				counter=counter-2;
				System.out.println(numbers[m][0]+" has more than 2 elements extra "+counter);
				break;

			}
			//System.out.println(counter);
		}
		//Yandan gelecekler ve ortadan çekilecekler
		for(int b=0; b<3; b++) {
			int gettingNear=rnd.nextInt(stok.size());
			int gettingCenter=rnd.nextInt(stok.size());
			YandanAl.add(gettingNear);
			YeniAl.add(gettingCenter);
			stok.remove(gettingCenter);
			stok.remove(gettingCenter);
		}
		//System.out.println("--------------");
		//System.out.println(a);
		//Eger elemanýmda 0 varsa onu atilacak olarak koydum
		for(int j=0; j<p1.size(); j++) {
			if(p1.contains(0)) {
				p1.remove(0);
				thrower.add(0);
			}
		}

		int DoubleSayac=0;
		ArrayList<Integer> setterP1=(ArrayList<Integer>) p1.clone();
		//4 tane 2 li grup cýkartýyorum 17 tas oldugu icin illa 4 tane 2 li cýkar
		for(int h=0; h<numbers.length; h++) {

			
			if((setterP1.contains(numbers[h][0]))&& numbers[h][1]>=2) {
				if(DoubleSayac==4) {
					break;
				}

				setterP1.remove(new Integer(numbers[h][0]));
				setterP1.remove(new Integer(numbers[h][0]));
				dblGrp.add(numbers[h][0]);
				dblGrp.add(numbers[h][0]);
				DoubleSayac++;

			}
		}
		
		int type=dblGrp.size()/2;
		
		System.out.println(setterP1);
		System.out.println(type+" Double group avaiable ");
		System.out.println(dblGrp);
		//System.out.println(setterP1);
		//System.out.println(p1);
		//System.out.println(thrower);
		//ArrayList<Integer> triple=new ArrayList<>();
	System.out.println("klonu");
	//Oluþan 2 tane 3 luyu buraya ekleriz
	grp3=TripleCombine(setterP1);
		//setterP1.removeAll(grp3);**************Su kýsým hata verdi
		//Kalan setterP1 elemanlarýndan sistem rastgele secer
		//yandanAl veya YeniAl kýsmýný rastgele seceriz 1=yandanAl 2=YeniAl
		//ona göre bir kere döndürüz for loopta 1 tane 3lü cýkýnca onu grp3 arraylistine atariz 
		// cýkmazsa rastgele 3 tas thrower arraylistine atarýz

	}
	//Burada aslýnda genel bir while acilabilir direkt bitirmek icin ama oyunda 2 kez olsun böylece tur döner
	private static ArrayList<Integer> TripleCombine(ArrayList<Integer> Singles) {
		int ucluGrup=0;
		ArrayList<Integer> kopyasi= (ArrayList<Integer>) Singles.clone();
		ArrayList <Integer> ucluk=new ArrayList<>();
		//Eger bu if kýsmý dogru olursa bunu ucluk arrayListine atarýz butun sayýlarýný
		for(int a=0; a<3; a++) {
			int m=rnd.nextInt(kopyasi.size());
			ucluk.add(kopyasi.get(m));
			
		}
		Collections.sort(kopyasi);
		//bu kýsým eger dogru cýkarsa
		if(kopyasi.get(0)+kopyasi.get(1)==kopyasi.get(2)) {
			System.out.println("Olur bu");
			ucluk.add(kopyasi.get(2));
			ucluk.add(kopyasi.get(1));
			ucluk.add(kopyasi.get(0));
			kopyasi.clear();
			ucluGrup++;
		}else {
			System.out.println("Sýkýntý");
		}
		if(ucluGrup==2) {
			return ucluk;
		}
		return null;
	}
	private static int[][] designer() {
		int [][]arrayer =new int[14][2];
		for(int h=0; h<arrayer.length; h++) {
			arrayer[h][0]=h;
		}

		for(int h=0; h<arrayer.length; h++) {
			for(int j=0; j<arrayer[h].length; j++) {
				System.out.print(arrayer[h][j]+" ");
			}
			System.out.println();
		}
		return arrayer;
	}
}
//random da grupta olabilir
/*
 * 17=3*a + 2.b  grouping
 *  	1	7  1*(grp 3) && 7*(grp 2)
 *  	3	4
 *  	5	1
 *  
 *  a,b>=1

 * */
