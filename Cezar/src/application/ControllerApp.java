package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerApp {
	static int leng;
	String str ="абвгдеєжзиіїйклмнопрстуфхцчшщьюяАБВГДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ-";

	@FXML
	private TextField tfcget;
	@FXML
	private TextField tfzget;
	@FXML
	private TextField tfpget;
	@FXML
	private TextField tfgget;
	
	@FXML
	private TextField tfcres;
	@FXML
	private TextField tfzres;
	@FXML
	private TextField tfpres;
	@FXML
	private TextField tfgres;
	
	@FXML
	private TextField tfckey;
	@FXML
	private TextField tfpkey;
	@FXML
	private TextField tfgkey;
	
	@FXML
	private Button bcshif;
	@FXML
	private Button bzshif;
	@FXML
	private Button bpshif;
	@FXML
	private Button bgshif;
	
	@FXML
	private Button bcdeshif;
	@FXML
	private Button bzdeshif;
	@FXML
	private Button bpdeshif;
	@FXML
	private Button bgdeshif;
	
	public void cezarShifr(){
		//btshif.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
		char mas[] = str.toCharArray();
		int key=0;
			try{
				key=Integer.parseInt(tfckey.getText());}
			catch(Exception e){
				e.getStackTrace();
			}
		if(key<1){key=1;}
		char get[] = tfcget.getText().toCharArray();
		String res="";
		for(int i=0; i<get.length; i++){
			for(int j=0; j<mas.length; j++){
				if(get[i]==mas[j]){
					res=res+mas[((j+key)%mas.length)];
				}
			}
		}
		tfcres.setText(res);
	}
	
	public void cezarDeShifr(){
		char mas[] = str.toCharArray();
		int key=0;
		try{
			key=Integer.parseInt(tfckey.getText());}
		catch(Exception e){
			e.getStackTrace();
		}
		if(key<1){key=1;}
		char get[] = tfcget.getText().toCharArray();
		String res="";
		for(int i=0; i<get.length; i++){
			for(int j=0; j<mas.length; j++){
				if(get[i]==mas[j]){
					if(j-key<0){
						res=res+mas[mas.length+j-key];
					}else
					res=res+mas[((j-key)%mas.length)];
				}
			}
		}
		tfcres.setText(res);
	}
	
	public void changeShifr(){
		int key=-1;
		try{
			key=Integer.parseInt(tfckey.getText());}
		catch(Exception e){
			e.getStackTrace();

		}
		if(key<0){key=0;}
		String str2 ="йцукенгшщзхїфівапролджєячсмитьбю-ЙЦУКЕНГШЩЗХЇФІВАПРОЛДЖЄЯЧСМИТЬБЮ";
		char change[] =str2.toCharArray();
		char mas[] = str.toString().toCharArray();
		char get[] = tfzget.getText().toString().toCharArray();
		String res ="";
		System.out.println();

		for(int i =0; i<get.length; i++){
			for(int j=0; j<mas.length; j++){
				if(get[i]!=' ') {
					if (get[i] == mas[j]) {
						res += change[j];
					}
				}else{
					res+=' ';
					break;
				}
			}
		}
		tfzres.setText(res);

	}

	public void changeDeShifr(){
		int key=-1;
		try{
			key=Integer.parseInt(tfckey.getText());}
		catch(Exception e){
			e.getStackTrace();

		}
		if(key<0){key=0;}
		String str2 ="йцукенгшщзхїфівапролджєячсмитьбю-ЙЦУКЕНГШЩЗХЇФІВАПРОЛДЖЄЯЧСМИТЬБЮ";
		char change[] =str2.toCharArray();
		char mas[] = str.toString().toCharArray();
		char get[] = tfzget.getText().toString().toCharArray();
		String res ="";
		System.out.println();

		for(int i =0; i<get.length; i++){
			for(int j=0; j<mas.length; j++){
				if(get[i]!=' ') {
					if (get[i] == change[j]) {
						res += mas[j];
					}
				}else{
					res+=' ';
					break;
				}
			}
		}
		tfzres.setText(res);

	}

	public char[][] getMatrix(){
		char[][] matrix=new char[0][0];
		String key = tfpkey.getText();
		String text = tfpget.getText().replaceAll(" ", "");
		int a= text.length()/key.length();
		double b = (double)text.length()/(double)key.length();
		if((double)a==b){
			matrix=new char[a+1][key.length()];
			leng =key.length();
		}else if((double)a<b) {
			matrix = new char[a + 2][key.length()];
			leng = key.length();
		}

		matrix[0] = key.toCharArray();
		return matrix;
	}

	public void perestShifr(){
		char matrix[][] = getMatrix();
		char key[] = tfpkey.getText().toCharArray();
		String tryh = tfpget.getText().replaceAll(" ", "");

		while(tryh.length()%key.length!=0){
			tryh+="-";
		}
		char get[] = tryh.toCharArray();
		int t=0;
		for (int i = 1; i< matrix.length; i++){
			for (int j = 0; j< leng; j++){
				matrix[i][j]=get[t];
				t++;
			}
		}
		String res="";
		for(int i=0; i<str.length(); i++){
			for (int j = 0; j< leng; j++){
				if(str.charAt(i)==matrix[0][j]){
					for(t=1; t< matrix.length; t++){
						res+=matrix[t][j];
					}
					res+=" ";
				}
			}
		}
		tfpres.setText(res);
	}

	public void perestDeShifr(){
		char matrix[][] = getMatrix();
		char get[]=tfpget.getText().toCharArray();
		int o=0;
		for(int i=0; i<str.length(); i++){
			for(int j=0; j<leng; j++){
				if(str.charAt(i)==matrix[0][j]){
					for(int t=1; t<matrix.length; t++){
						matrix[t][j]=get[o];
						o++;
					}
					o++;
				}

			}
		}
		String res="";
		for(int i=1; i<matrix.length; i++) {
			for (int j = 0; j < leng; j++) {
				if (matrix[i][j] == '-' && (i == matrix.length - 1)) {
					break;
				}
				res += matrix[i][j];
			}
		}
		tfpres.setText(res);
	}

	public void gamuvShifr(){
		char key[] = tfgkey.getText().toCharArray();
		char get[] = tfgget.getText().replace(" ", "").toCharArray();

		int ckey[] = new int[key.length];
		for(int i=0; i<key.length; i++){
			for (int j=0; j<str.length(); j++){
				if(str.charAt(j)==key[i]){
					ckey[i]=j;
					break;
				}
			}
		}
		String res="";
		int temp=0;
		for(int i=0; i<get.length; i++){
			if(temp==ckey.length-1){
				temp=0;
			}
			res+=str.charAt((ckey[temp]+str.indexOf(get[i]))%str.length());
			temp++;
		}
		tfgres.setText(res);
	}

	public void gamuvDeShifr(){
		char key[] = tfgkey.getText().toCharArray();
		char get[] = tfgget.getText().replace(" ", "").toCharArray();

		int ckey[] = new int[key.length];
		for(int i=0; i<key.length; i++){
			for (int j=0; j<str.length(); j++){
				if(str.charAt(j)==key[i]){
					ckey[i]=j;
					break;
				}
			}
		}

		String res="";
		int temp=0;
		for(int i=0; i<get.length; i++){
			if(temp==ckey.length-1){
				temp=0;
			}
			res+=str.charAt((str.indexOf(get[i])-ckey[temp])%str.length());
			temp++;
		}
		tfgres.setText(res);
	}
}