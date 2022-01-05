import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OyunAlani extends JPanel{
	
	public int[][] alan;
	public List<Integer> altinKoor = new ArrayList<Integer>();
	public List<Integer> gizliAltinKoor = new ArrayList<Integer>();
	public int row;
	public int coloumn;
	public int alanAltinOrani;
	public int alanAltinSayisi;
	public int alanGizliAltinOrani;
	public int baslangicAltinSayisi;
	public int gizliAltinSayisi;
	public int adimdaAlinanYol;
	public int hamleMaliyeti;
	public int aOyuncuHedefMal;
	public int bOyuncuHedefMal;
	public int cOyuncuHedefMal;
	public int dOyuncuHedefMal;
	
	public OyunAlani(int row, int coloumn, int altinOran, int gizliAltinOran, int basAltin, int adimdaAlinanY, int hamleMaliyet, int aHedefMal, int bHedefMal, int cHedefMal, int dHedefMal) {
				
		this.row = row;
		this.coloumn = coloumn;
		this.alanAltinOrani = altinOran;
		this.alanGizliAltinOrani = gizliAltinOran;
		this.baslangicAltinSayisi = basAltin;
		this.adimdaAlinanYol = adimdaAlinanY;
		this.hamleMaliyeti = hamleMaliyet;
		this.aOyuncuHedefMal = aHedefMal;
		this.bOyuncuHedefMal = bHedefMal;
		this.cOyuncuHedefMal = cHedefMal;
		this.dOyuncuHedefMal = dHedefMal;
		
		float rowF = row;
		float colF = coloumn;
		float alanAltinOranF = altinOran;
		float alanGizliAltinOranF = gizliAltinOran;
		
		float alanAltinF = (float) (((rowF * colF) * alanAltinOranF) / 100.0);
		float gizliF = (float) ((alanAltinF * alanGizliAltinOranF) / 100.0);
		alanAltinF = alanAltinF - gizliF;
				
		this.alanAltinSayisi = (int) Math.ceil(alanAltinF);
		this.gizliAltinSayisi = (int) Math.ceil(gizliF);
		
		this.alan = new int[row][coloumn];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < coloumn; j++) {
				this.alan[i][j] = 0;
			}
		}
		
		int altinSayac = 0;
		int gizliAltinSayac = 0;
		
		this.alan[0][0] = 6;
		this.alan[0][(coloumn-1)] = 7;
		this.alan[row-1][0] = 8;
		this.alan[row-1][coloumn-1] = 9;
		
		while(altinSayac < alanAltinSayisi) {
			
			Random rn = new Random();
			int row_koor = rn.nextInt(row);
			int coloumn_koor = rn.nextInt(coloumn);
			
			if(alan[row_koor][coloumn_koor] == 0 ) {
				Random rn2 = new Random();
				this.alan[row_koor][coloumn_koor] = rn2.nextInt(4) + 1;
				this.altinKoor.add(row_koor);
				this.altinKoor.add(coloumn_koor);
				altinSayac++;
			}
		}
		
		while(gizliAltinSayac < gizliAltinSayisi) {
			
			Random rn1 = new Random();
			int row_koor = rn1.nextInt(row);
			int coloumn_koor = rn1.nextInt(coloumn);
			
			if(alan[row_koor][coloumn_koor] == 0 ) {
				this.alan[row_koor][coloumn_koor] = 5;
				this.gizliAltinKoor.add(row_koor);
				this.gizliAltinKoor.add(coloumn_koor);
				gizliAltinSayac++;
			}
		}		
		
		OyuncuA aOyuncu = new OyuncuA(0, 0, adimdaAlinanYol, baslangicAltinSayisi, aOyuncuHedefMal, hamleMaliyeti);
		OyuncuB bOyuncu = new OyuncuB(0, (coloumn-1), adimdaAlinanYol, baslangicAltinSayisi, bOyuncuHedefMal, hamleMaliyeti);
		OyuncuC cOyuncu = new OyuncuC((row-1), 0, adimdaAlinanYol, baslangicAltinSayisi, cOyuncuHedefMal, hamleMaliyeti);
		OyuncuD dOyuncu = new OyuncuD((row-1), (coloumn-1), adimdaAlinanYol, baslangicAltinSayisi, dOyuncuHedefMal, hamleMaliyeti);

		PrintWriter yazici_1;
		try {
			yazici_1 = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
			String str = "A oyuncusu koordinatlari: " + aOyuncu.getXKoordinat() + ", " + aOyuncu.getYKoordinat() + " altinlar: " + aOyuncu.getAltinSayisi();
			yazici_1.append(str);
			yazici_1.append("\n");
			String str2 = "\nB oyuncusu koordinatlari: " + bOyuncu.getXKoordinat() + ", " + bOyuncu.getYKoordinat() + " altinlar: " + bOyuncu.getAltinSayisi();
			yazici_1.append(str2);
			yazici_1.append("\n");
			String str3 = "\nC oyuncusu koordinatlari: " + cOyuncu.getXKoordinat() + ", " + cOyuncu.getYKoordinat() + " altinlar: " + cOyuncu.getAltinSayisi();
			yazici_1.append(str3);
			yazici_1.append("\n");
			String str4 = "\nD oyuncusu koordinatlari: " + dOyuncu.getXKoordinat() + ", " + dOyuncu.getYKoordinat() + " altinlar: " + dOyuncu.getAltinSayisi();
			yazici_1.append(str4);
			yazici_1.append("\n");
			yazici_1.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		int altinSayaci = alanAltinSayisi + gizliAltinSayisi;
		
		while(altinSayaci > 0) {
			
			//A'nin Sirasi
			aOyuncu.setSirasiGeldiMi(true);
			if(aOyuncu.getSirasiGeldiMi() == true) {
				
				if(aOyuncu.getHedefBelliMi() == false) {
					aOyuncu.AHedefBelirle(aOyuncu.getXKoordinat(), aOyuncu.getYKoordinat(), altinKoor, alan);
					aOyuncu.setHedefBelliMi(true);
					aOyuncu.setAltinSayisi(aOyuncu.getAltinSayisi() - aOyuncu.getHedefBelirlemeMaliyeti());
					PrintWriter yazici;
					try {
						yazici = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
						String str = "\nA oyuncusu hedef belirledi: " + aOyuncu.getHedefXKoordinat() + ", " + aOyuncu.getHedefYKoordinat() + " altinlar: " + aOyuncu.getAltinSayisi();
						yazici.append(str);
						yazici.append("\n");						
						yazici.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					
					Timer timer = new Timer(1000, new ActionListener() {
				    public void actionPerformed(ActionEvent evt) {
					//...Back...
				    	int sayac = 0;
				    	for(int i = aOyuncu.hangiAdimdaKaldi; i < aOyuncu.yol.size(); i = i + 2) {
							if(sayac < adimdaAlinanYol) {
								
							alan[aOyuncu.yol.get(i)][aOyuncu.yol.get(i+1)] = 6;	
							alan[aOyuncu.getXKoordinat()][aOyuncu.getYKoordinat()] = 0;
							aOyuncu.setXKoordinat(aOyuncu.yol.get(i));
							aOyuncu.setYKoordinat(aOyuncu.yol.get(i+1));
							sayac++;
							repaint();
							
							if(sayac == adimdaAlinanYol) {
								aOyuncu.setAltinSayisi(aOyuncu.getAltinSayisi() - aOyuncu.getAdimMaliyet());
							}
							
							PrintWriter yazici;
							try {
								yazici = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
								String str = "\nA oyuncusu " + aOyuncu.getXKoordinat() + ", " + aOyuncu.getYKoordinat() + " koordinatlarina hareket etti." + " altinlar: " + aOyuncu.getAltinSayisi();
								yazici.append(str);
								yazici.append("\n");						
								yazici.close();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							if(aOyuncu.getXKoordinat() == aOyuncu.yol.get(aOyuncu.yol.size()-2) && aOyuncu.getYKoordinat() == aOyuncu.yol.get(aOyuncu.yol.size()-1)) {
								
								for(int j = 0; j < altinKoor.size(); j = j + 2) {
									if(aOyuncu.getHedefXKoordinat() == altinKoor.get(j) && aOyuncu.getHedefYKoordinat() == altinKoor.get(j+1)) {
										aOyuncu.setAltinSayisi(aOyuncu.getAltinSayisi() + (aOyuncu.hedefAltin*5));
										altinKoor.remove(j);
										altinKoor.remove(j);
										
										if(sayac < adimdaAlinanYol) {
											aOyuncu.setAltinSayisi(aOyuncu.getAltinSayisi() - aOyuncu.getAdimMaliyet());
										}
										
										PrintWriter yazici_2;
										try {
											yazici_2 = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
											String str = "\nA oyuncusu hedefine ulasti." + " altinlar: " + aOyuncu.getAltinSayisi();
											yazici_2.append(str);
											yazici_2.append("\n");						
											yazici_2.close();
										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
									}								
								}
								aOyuncu.yol.clear();
								aOyuncu.setSirasiGeldiMi(false);
								aOyuncu.setHedefBelliMi(false);
								bOyuncu.setSirasiGeldiMi(true);
							}
								}
							}	
				    	aOyuncu.setHangiAdimdaKaldi(aOyuncu.getHangiAdimdaKaldi() + (sayac*2));
				    	sayac = 0;
				            //...GUI...
				            repaint();		        
				    }    
				});
				timer.start();			
				
				}
				
			}
			
			//B'nin Sirasi
			bOyuncu.setSirasiGeldiMi(true);
			if(bOyuncu.getSirasiGeldiMi() == true) {
				
				if(bOyuncu.getHedefBelliMi() == false) {
					bOyuncu.BHedefBelirle(bOyuncu.getXKoordinat(), bOyuncu.getYKoordinat(), altinKoor, alan);
					bOyuncu.setHedefBelliMi(true);
					bOyuncu.setAltinSayisi(bOyuncu.getAltinSayisi() - bOyuncu.getHedefBelirlemeMaliyeti());
					PrintWriter yazici;
					try {
						yazici = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
						String str = "\nB oyuncusu hedef belirledi: " + bOyuncu.getHedefXKoordinat() + ", " + bOyuncu.getHedefYKoordinat() + " altinlar: " + bOyuncu.getAltinSayisi();
						yazici.append(str);
						yazici.append("\n");						
						yazici.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					
					Timer timer = new Timer(2000, new ActionListener() {
				    public void actionPerformed(ActionEvent evt) {
					//...Back...
				    	int sayac = 0;
				    	for(int i = bOyuncu.hangiAdimdaKaldi; i < bOyuncu.yol.size(); i = i + 2) {
							if(sayac < adimdaAlinanYol) {
								
							alan[bOyuncu.yol.get(i)][bOyuncu.yol.get(i+1)] = 7;	
							alan[bOyuncu.getXKoordinat()][bOyuncu.getYKoordinat()] = 0;
							bOyuncu.setXKoordinat(bOyuncu.yol.get(i));
							bOyuncu.setYKoordinat(bOyuncu.yol.get(i+1));
							sayac++;
							repaint();
							
							if(sayac == adimdaAlinanYol) {
								bOyuncu.setAltinSayisi(bOyuncu.getAltinSayisi() - bOyuncu.getAdimMaliyet());
							}
							
							PrintWriter yazici;
							try {
								yazici = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
								String str = "\nB oyuncusu " + bOyuncu.getXKoordinat() + ", " + bOyuncu.getYKoordinat() + " koordinatlarina hareket etti." + " altinlar: " + bOyuncu.getAltinSayisi();
								yazici.append(str);
								yazici.append("\n");						
								yazici.close();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							if(bOyuncu.getXKoordinat() == bOyuncu.yol.get(bOyuncu.yol.size()-2) && bOyuncu.getYKoordinat() == bOyuncu.yol.get(bOyuncu.yol.size()-1)) {	
								
								for(int j = 0; j < altinKoor.size(); j = j + 2) {
									if(bOyuncu.getHedefXKoordinat() == altinKoor.get(j) && bOyuncu.getHedefYKoordinat() == altinKoor.get(j+1)) {
										bOyuncu.setAltinSayisi(bOyuncu.getAltinSayisi() + (bOyuncu.hedefAltin*5));
										altinKoor.remove(j);
										altinKoor.remove(j);
										
										if(sayac < adimdaAlinanYol) {
											bOyuncu.setAltinSayisi(bOyuncu.getAltinSayisi() - bOyuncu.getAdimMaliyet());
										}
										
										PrintWriter yazici_2;
										try {
											yazici_2 = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
											String str = "\nB oyuncusu hedefine ulasti." + " altinlar: " + bOyuncu.getAltinSayisi();
											yazici_2.append(str);
											yazici_2.append("\n");						
											yazici_2.close();
										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
									}								
								}
								bOyuncu.yol.clear();
								bOyuncu.setSirasiGeldiMi(false);
								bOyuncu.setHedefBelliMi(false);
								cOyuncu.setSirasiGeldiMi(true);
							}
								}
							}	
				    	bOyuncu.setHangiAdimdaKaldi(bOyuncu.getHangiAdimdaKaldi() + (sayac*2));
				    	sayac = 0;
				            //...GUI...
				            repaint();		        
				    }    
				});
				timer.start();			
					
				}
				
			}		
			
			//C'nin Sirasi
			
			cOyuncu.setSirasiGeldiMi(true);
			if(cOyuncu.getSirasiGeldiMi() == true) {
				
				if(cOyuncu.getHedefBelliMi() == false) {
					//C en yakin 2 gizliyi acsin
					
					Timer timer = new Timer(3000, new ActionListener() {
					    public void actionPerformed(ActionEvent evt) {
						//...Back...
					    	int gorX = 0;
							int gorY = 0;
							if(gizliAltinKoor.size() != 0) {
								int cGormeSayac = 0;
								
								while(cGormeSayac < 2) {							
								
								int enYakinGizli = Integer.MAX_VALUE;
								
								for(int i = 0; i < gizliAltinKoor.size(); i = i + 2) {
									
									int enYakin = (Math.abs(gizliAltinKoor.get(i) - cOyuncu.getXKoordinat())) + (Math.abs(gizliAltinKoor.get(i+1) - cOyuncu.getYKoordinat()));
									
									if(enYakin < enYakinGizli) {
										gorX = gizliAltinKoor.get(i);
										gorY = gizliAltinKoor.get(i+1);
										enYakinGizli = enYakin;
									}			
								}
								
								for(int i = 0; i < gizliAltinKoor.size(); i = i + 2) {
									if(gorX == gizliAltinKoor.get(i) && gorY == gizliAltinKoor.get(i+1)) {
										Random rnGiz = new Random();
										alan[gorX][gorY] = rnGiz.nextInt(4) + 1;
										gizliAltinKoor.remove(i);
										gizliAltinKoor.remove(i);
										altinKoor.add(gorX);
										altinKoor.add(gorY);
									}
								}
								cGormeSayac++;
								repaint();
							  }
								
							}
					            //...GUI...
					            repaint();		        
					    }    
					});
					timer.start();
					
					//Acildi
					
					cOyuncu.CHedefBelirle(cOyuncu.getXKoordinat(), cOyuncu.getYKoordinat(), altinKoor, alan);
					cOyuncu.setHedefBelliMi(true);
					cOyuncu.setAltinSayisi(cOyuncu.getAltinSayisi() - cOyuncu.getHedefBelirlemeMaliyeti());
					PrintWriter yazici;
					try {
						yazici = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
						String str = "\nC oyuncusu hedef belirledi: " + cOyuncu.getHedefXKoordinat() + ", " + cOyuncu.getHedefYKoordinat() + " altinlar: " + cOyuncu.getAltinSayisi();
						yazici.append(str);
						yazici.append("\n");						
						yazici.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					
					Timer timer = new Timer(4000, new ActionListener() {
				    public void actionPerformed(ActionEvent evt) {
					//...Back...
				    	int sayac = 0;
				    	for(int i = cOyuncu.hangiAdimdaKaldi; i < cOyuncu.yol.size(); i = i + 2) {
							if(sayac < adimdaAlinanYol) {
								
							alan[cOyuncu.yol.get(i)][cOyuncu.yol.get(i+1)] = 8;	
							alan[cOyuncu.getXKoordinat()][cOyuncu.getYKoordinat()] = 0;
							cOyuncu.setXKoordinat(cOyuncu.yol.get(i));
							cOyuncu.setYKoordinat(cOyuncu.yol.get(i+1));
							sayac++;
							repaint();
							
							if(sayac == adimdaAlinanYol) {
								cOyuncu.setAltinSayisi(cOyuncu.getAltinSayisi() - cOyuncu.getAdimMaliyet());
							}
							
							PrintWriter yazici;
							try {
								yazici = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
								String str = "\nC oyuncusu " + cOyuncu.getXKoordinat() + ", " + cOyuncu.getYKoordinat() + " koordinatlarina hareket etti." + " altinlar: " + cOyuncu.getAltinSayisi();
								yazici.append(str);
								yazici.append("\n");						
								yazici.close();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							if(cOyuncu.getXKoordinat() == cOyuncu.yol.get(cOyuncu.yol.size()-2) && cOyuncu.getYKoordinat() == cOyuncu.yol.get(cOyuncu.yol.size()-1)) {	
								
								for(int j = 0; j < altinKoor.size(); j = j + 2) {
									if(cOyuncu.getHedefXKoordinat() == altinKoor.get(j) && cOyuncu.getHedefYKoordinat() == altinKoor.get(j+1)) {
										cOyuncu.setAltinSayisi(cOyuncu.getAltinSayisi() + (cOyuncu.hedefAltin*5));
										altinKoor.remove(j);
										altinKoor.remove(j);
										
										if(sayac < adimdaAlinanYol) {
											cOyuncu.setAltinSayisi(cOyuncu.getAltinSayisi() - cOyuncu.getAdimMaliyet());
										}
										
										PrintWriter yazici_2;
										try {
											yazici_2 = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
											String str = "\nC oyuncusu hedefine ulasti." + " altinlar: " + cOyuncu.getAltinSayisi();
											yazici_2.append(str);
											yazici_2.append("\n");						
											yazici_2.close();
										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
									}								
								}
								cOyuncu.yol.clear();
								cOyuncu.setSirasiGeldiMi(false);
								cOyuncu.setHedefBelliMi(false);
							}
								}
							}	
				    	cOyuncu.setHangiAdimdaKaldi(cOyuncu.getHangiAdimdaKaldi() + (sayac*2));
				    	sayac = 0;
				            //...GUI...
				            repaint();		        
				    }    
				});
				timer.start();			
					
				}
				
			}
								
			//D'nin Sirasi
			dOyuncu.setSirasiGeldiMi(true);
			if(dOyuncu.getSirasiGeldiMi() == true) {
				
				if(dOyuncu.getHedefBelliMi() == false) {
					dOyuncu.DHedefBelirle(dOyuncu.getXKoordinat(), dOyuncu.getYKoordinat(), altinKoor, alan);
					dOyuncu.setHedefBelliMi(true);
					
					List<Integer> dKontrol = new ArrayList<Integer>(altinKoor);
					
					if(dOyuncu.getHedefXKoordinat() == aOyuncu.getHedefXKoordinat() && dOyuncu.getHedefYKoordinat() == aOyuncu.getHedefYKoordinat() && dOyuncu.yol.size() < aOyuncu.yol.size()) {
						for(int i = 0; i < dKontrol.size(); i = i+2) {
							if(dOyuncu.getHedefXKoordinat() == dKontrol.get(i) && dOyuncu.getHedefYKoordinat() == dKontrol.get(i+1)) {
								dKontrol.remove(i);
								dKontrol.remove(i);
							}							
						}
						dOyuncu.DHedefBelirle(dOyuncu.getXKoordinat(), dOyuncu.getYKoordinat(), dKontrol, alan);
					}else if(dOyuncu.getHedefXKoordinat() == bOyuncu.getHedefXKoordinat() && dOyuncu.getHedefYKoordinat() == bOyuncu.getHedefYKoordinat() && dOyuncu.yol.size() < bOyuncu.yol.size()) {
						for(int i = 0; i < dKontrol.size(); i = i+2) {
							if(dOyuncu.getHedefXKoordinat() == dKontrol.get(i) && dOyuncu.getHedefYKoordinat() == dKontrol.get(i+1)) {
								dKontrol.remove(i);
								dKontrol.remove(i);
							}							
						}
						dOyuncu.DHedefBelirle(dOyuncu.getXKoordinat(), dOyuncu.getYKoordinat(), dKontrol, alan);
					}else if(dOyuncu.getHedefXKoordinat() == cOyuncu.getHedefXKoordinat() && dOyuncu.getHedefYKoordinat() == cOyuncu.getHedefYKoordinat() && dOyuncu.yol.size() < cOyuncu.yol.size()) {
						for(int i = 0; i < dKontrol.size(); i = i+2) {
							if(dOyuncu.getHedefXKoordinat() == dKontrol.get(i) && dOyuncu.getHedefYKoordinat() == dKontrol.get(i+1)) {
								dKontrol.remove(i);
								dKontrol.remove(i);
							}							
						}
						dOyuncu.DHedefBelirle(dOyuncu.getXKoordinat(), dOyuncu.getYKoordinat(), dKontrol, alan);
					}
					
					dOyuncu.setAltinSayisi(dOyuncu.getAltinSayisi() - dOyuncu.getHedefBelirlemeMaliyeti());
					PrintWriter yazici;
					try {
						yazici = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
						String str = "\nD oyuncusu hedef belirledi: " + dOyuncu.getHedefXKoordinat() + ", " + dOyuncu.getHedefYKoordinat() + " altinlar: " + dOyuncu.getAltinSayisi();
						yazici.append(str);
						yazici.append("\n");						
						yazici.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					
					Timer timer = new Timer(5000, new ActionListener() {
				    public void actionPerformed(ActionEvent evt) {
					//...Back...
				    	int sayac = 0;
				    	for(int i = dOyuncu.hangiAdimdaKaldi; i < dOyuncu.yol.size(); i = i + 2) {
							if(sayac < adimdaAlinanYol) {
								
							alan[dOyuncu.yol.get(i)][dOyuncu.yol.get(i+1)] = 9;	
							alan[dOyuncu.getXKoordinat()][dOyuncu.getYKoordinat()] = 0;
							dOyuncu.setXKoordinat(dOyuncu.yol.get(i));
							dOyuncu.setYKoordinat(dOyuncu.yol.get(i+1));
							sayac++;
							repaint();
							
							if(sayac == adimdaAlinanYol) {
								dOyuncu.setAltinSayisi(dOyuncu.getAltinSayisi() - dOyuncu.getAdimMaliyet());
							}
							
							PrintWriter yazici;
							try {
								yazici = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
								String str = "\nD oyuncusu " + dOyuncu.getXKoordinat() + ", " + dOyuncu.getYKoordinat() + " koordinatlarina hareket etti." + " altinlar: " + dOyuncu.getAltinSayisi();
								yazici.append(str);
								yazici.append("\n");						
								yazici.close();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							if(dOyuncu.getXKoordinat() == dOyuncu.yol.get(dOyuncu.yol.size()-2) && dOyuncu.getYKoordinat() == dOyuncu.yol.get(dOyuncu.yol.size()-1)) {	
								
								for(int j = 0; j < altinKoor.size(); j = j + 2) {
									if(dOyuncu.getHedefXKoordinat() == altinKoor.get(j) && dOyuncu.getHedefYKoordinat() == altinKoor.get(j+1)) {
										dOyuncu.setAltinSayisi(dOyuncu.getAltinSayisi() + (dOyuncu.hedefAltin*5));
										altinKoor.remove(j);
										altinKoor.remove(j);
										
										if(sayac < adimdaAlinanYol) {
											dOyuncu.setAltinSayisi(dOyuncu.getAltinSayisi() - dOyuncu.getAdimMaliyet());
										}
										
										PrintWriter yazici_2;
										try {
											yazici_2 = new PrintWriter(new FileOutputStream(("cikti.txt"),true));
											String str = "\nD oyuncusu hedefine ulasti." + " altinlar: " + dOyuncu.getAltinSayisi();
											yazici_2.append(str);
											yazici_2.append("\n");						
											yazici_2.close();
										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
									}								
								}
								dOyuncu.yol.clear();
								dOyuncu.setSirasiGeldiMi(false);
								dOyuncu.setHedefBelliMi(false);
								aOyuncu.setSirasiGeldiMi(true);
							}
								}
							}	
				    	dOyuncu.setHangiAdimdaKaldi(dOyuncu.getHangiAdimdaKaldi() + (sayac*2));
				    	sayac = 0;
				            //...GUI...
				            repaint();		        
				    }    
				});
				timer.start();			
					
				}
				
			}			
			altinSayaci--;
		}

	}
		
    public Dimension getPreferredSize() {
        return new Dimension((this.alan[0].length)*30, (this.alan.length)*30);
    }
	
	@Override
	public void paintComponent(Graphics g)  {
		
		super.paintComponent(g);
		g.translate(0, 0);
								
		for(int i = 0; i < this.alan.length; i++) {
			for(int j = 0; j < this.alan[0].length; j++) {
				
				Color color = null;
				if(this.alan[i][j] == 0){
					color = Color.WHITE;
				}else if(this.alan[i][j] == 1){
					color = Color.YELLOW;
				}else if(this.alan[i][j] == 2){
					color = Color.ORANGE;
				}else if(this.alan[i][j] == 3){
					color = Color.RED;
				}else if(this.alan[i][j] == 4){
					color = Color.MAGENTA;
				}else if(this.alan[i][j] == 5){
					color = Color.DARK_GRAY;
				}else if(this.alan[i][j] == 6){
					color = Color.GREEN;
				}else if(this.alan[i][j] == 7){
					color = Color.BLUE;
				}else if(this.alan[i][j] == 8){
					color = Color.CYAN;
				}else if(this.alan[i][j] == 9){
					color = Color.PINK;
				}
				
				g.setColor(color);
				g.fillRect(25 * j, 25 * i, 25, 25);
				g.setColor(Color.BLACK);
				g.drawRect(25 * j, 25 * i, 25, 25);

			}
		}
		
	}	

}
