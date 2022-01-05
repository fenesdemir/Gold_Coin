import java.util.ArrayList;
import java.util.List;

public class OyuncuB {
	
	public int oyuncuID = 2;
	public int adimdaAlinanYol;
	public int altinSayisi;
	public int hedefBelirlemeMaliyeti;
	public int xKoordinat;
	public int yKoordinat;
	public int hedefXKoordinat;
	public int hedefYKoordinat;
	public int hangiAdimdaKaldi;
	public int adimMaliyet;
	public boolean hedefBelliMi;
	public boolean sirasiGeldiMi;
	public List<Integer> yol = new ArrayList<Integer>();
	public int hedefAltin;
	
	public OyuncuB(int x, int y, int alinanYol, int altin, int hedefMaliyet, int adimMaliyet) {
		this.adimdaAlinanYol = alinanYol;
		this.altinSayisi = altin;
		this.hedefBelirlemeMaliyeti = hedefMaliyet;
		this.xKoordinat = x;
		this.yKoordinat = y;
		this.adimMaliyet = adimMaliyet;
		this.hedefBelliMi = false;
		this.sirasiGeldiMi = false;
	}
	
	public void BHedefBelirle(int oyuncuX, int oyuncuY, List<Integer> altin, int alan[][]) {
		
		int yolMaliyeti = Integer.MAX_VALUE;
		List<Integer> yol_liste = new ArrayList<Integer>();
		
		for(int i = 0; i < altin.size(); i = i + 2) {
			
			int hedefAltinMiktari = 0;
			
			if(alan[altin.get(i)][altin.get(i+1)] == 1) {
				hedefAltinMiktari = 5;
			}else if(alan[altin.get(i)][altin.get(i+1)] == 2) {
				hedefAltinMiktari = 10;
			}else if(alan[altin.get(i)][altin.get(i+1)] == 3) {
				hedefAltinMiktari = 15;
			}else if(alan[altin.get(i)][altin.get(i+1)] == 4) {
				hedefAltinMiktari = 20;
			}
			
			int yol = (Math.abs(altin.get(i) - oyuncuX)) + (Math.abs(altin.get(i+1) - oyuncuY));
			int yolaHarcananAltin = ((yol / adimdaAlinanYol) * adimMaliyet) + hedefAltinMiktari;
			
			if(yolaHarcananAltin < yolMaliyeti) {
				setHedefXKoordinat(altin.get(i));
				setHedefYKoordinat(altin.get(i+1));
				yolMaliyeti = yolaHarcananAltin;
			}		
		}
		
		if(hedefXKoordinat > oyuncuX) {
			for(int i = oyuncuX; i <= hedefXKoordinat ; i++) {
				yol_liste.add(i);
				yol_liste.add(oyuncuY);
			}
		}else if(hedefXKoordinat < oyuncuX) {
			for(int i = oyuncuX; i >= hedefXKoordinat ; i--) {
				yol_liste.add(i);
				yol_liste.add(oyuncuY);
			}
		}else if(hedefXKoordinat == oyuncuX) {
			
		}
		
		if(hedefYKoordinat > oyuncuY) {
			for(int i = oyuncuY; i < hedefYKoordinat ; i++) {
				yol_liste.add(hedefXKoordinat);
				yol_liste.add(i+1);			
			}
		}else if(hedefYKoordinat < oyuncuY) {
			for(int i = oyuncuY; i > hedefYKoordinat ; i--) {
				yol_liste.add(hedefXKoordinat);
				yol_liste.add(i-1);								
			}
		}else if(hedefYKoordinat == oyuncuY) {
			
		}
		
		for(int i = 0; i < yol_liste.size(); i++) {
			yol.add(yol_liste.get(i));
		}
		
		this.hedefAltin = alan[hedefXKoordinat][hedefYKoordinat];
				
	}
	
	public void setAdimdaAlinanYol(int yol) {
		this.adimdaAlinanYol = yol;
	}
	
	public void setAltinSayisi(int altin) {
		this.altinSayisi = altin;
	}
	
	public void setHedefBelirlemeMaliyeti(int hedef) {
		this.hedefBelirlemeMaliyeti = hedef;
	}
	
	public void setXKoordinat(int x) {
		this.xKoordinat = x;
	}
	
	public void setYKoordinat(int y) {
		this.yKoordinat = y;
	}
	
	public void setHedefXKoordinat(int xHedef) {
		this.hedefXKoordinat = xHedef;
	}
	
	public void setHedefYKoordinat(int yHedef) {
		this.hedefYKoordinat = yHedef;
	}
	
	public void setHangiAdimdaKaldi(int kalanAdim) {
		this.hangiAdimdaKaldi = kalanAdim;
	}
	
	public void setAdimMaliyet(int aMaliyet) {
		this.adimMaliyet = aMaliyet;
	}
	
	public void setHedefBelliMi(boolean hedef) {
		this.hedefBelliMi = hedef;
	}
	
	public void setSirasiGeldiMi(boolean sira) {
		this.sirasiGeldiMi = sira;
	}
	
	public int getAdimdaAlinanYol() {
		return this.adimdaAlinanYol;
	}
	
	public int getAltinSayisi() {
		return this.altinSayisi;
	}
	
	public int getHedefBelirlemeMaliyeti() {
		return this.hedefBelirlemeMaliyeti;
	}
	
	public int getXKoordinat() {
		return this.xKoordinat;
	}
	
	public int getYKoordinat() {
		return this.yKoordinat;
	}
	
	public int getHedefXKoordinat() {
		return this.hedefXKoordinat;
	}
	
	public int getHedefYKoordinat() {
		return this.hedefYKoordinat;
	}
	
	public int getHangiAdimdaKaldi() {
		return this.hangiAdimdaKaldi;
	}
	
	public int getAdimMaliyet() {
		return this.adimMaliyet;
	}
	
	public boolean getHedefBelliMi() {
		return this.hedefBelliMi;
	}
	
	public boolean getSirasiGeldiMi() {
		return this.sirasiGeldiMi;
	}	

}
