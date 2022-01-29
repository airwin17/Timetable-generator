package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Population {
	private int popsize;
	private Chromosome[] chromosomes;
	private Chromosome fitest;
	public Population(int popsize) {
		System.out.println("done");
		this.popsize = popsize;
		this.chromosomes = new Chromosome[popsize];
		System.out.println("done0");

		GenerateChromosomes();
		System.out.println("done");

		GenerateClass();
		System.out.println("done2");

		for(int i=0;i<this.getChromosomes().length;i++) {
			this.getChromosomes()[i].calFitness();
			}
		System.out.println("done6");
	}
	public int getPopsize() {
		return popsize;
	}
	public void setPopsize(int popsize) {
		this.popsize = popsize;
	}
	public Chromosome[] getChromosomes() {
		return chromosomes;
	}
	public void setChromosomes(Chromosome[] chromosomes) {
		this.chromosomes = chromosomes;
	}
	public Chromosome getFitest() {
		return fitest;
	}
	public void setFitest(Chromosome fitest) {
		this.fitest = fitest;
	}
	public void GenerateChromosomes(){
		//Initialize Chromosome and add rooms
		for(int i=0 ; i < this.getChromosomes().length;i++) {
			Chromosome z =new Chromosome();
			getChromosomes()[i]=z;
			for(int p=0;p<Data.daysPerWeek;p++) {
				for(int o=0;o<Data.periodsPerDay;o++) {
					for(int u=0;u<Data.rooms.size();u++) {
						z.getTimetable()[p][o][u]= new Class(Data.rooms.get(u));
					}
				}
			}
		}
	}
	public void GenerateClass() {
		for(int i=0 ; i < this.getChromosomes().length;i++) {
			for(int p=0;p<Data.groups.size();p++) {
				for(int o=0;o<Data.groups.get(p).getModuleneeds().size();o++) {
					int a=(int) ((Math.random() * (Data.daysPerWeek - 0)));
					int b=(int) ((Math.random() * (Data.periodsPerDay - 0)));
					int c=(int) ((Math.random() * (Data.rooms.size() - 0)));
					while(this.getChromosomes()[i].getTimetable()[a][b][c].getGroupe()!=null) {
						System.out.println(a+b+c);
						a=(int) ((Math.random() * (Data.daysPerWeek)));
						b=(int) ((Math.random() * (Data.periodsPerDay)));
						c=(int) ((Math.random() * (Data.rooms.size())));
					}
					this.getChromosomes()[i].getTimetable()[a][b][c].setGroupe(Data.groups.get(p));
					this.getChromosomes()[i].getTimetable()[a][b][c].setModule(Data.module.get(o)); 
					this.getChromosomes()[i].getTimetable()[a][b][c].setInstructor(
							this.getChromosomes()[i].getTimetable()[a][b][c].getModule().getInstructors().get((int) ((Math.random()*
									this.getChromosomes()[i].getTimetable()[a][b][c].getModule().getInstructors().size()))));
				}
			}
		}
	}
	public Chromosome[] crossover(Chromosome p1,Chromosome p2) {
		Random random=new Random();
		Chromosome[] child=new Chromosome[10];
		for(int i=0;i<child.length;i++) {
			child[i]=new Chromosome();
			for(int p=0;p<Data.daysPerWeek;p++) {
				for(int o=0;o<Data.periodsPerDay;o++) {
					for(int u=0;u<Data.rooms.size();u++) {
						child[i].getTimetable()[p][o][u]= new Class(Data.rooms.get(u));
					}
				}
			}
		}
		for (int s = 0; s < child.length; s++) {
			if(s<(child.length/2)) {
				for (int i = 0; i < Data.daysPerWeek; i++) {
					for (int o = 0; o < Data.periodsPerDay; o++) {
						int j = random.nextInt(1);
						for (int p = 0; p < Data.rooms.size(); p++) {
							if (j == 0) {
								child[i].setClass(i, o, p, p1.getTimetable()[i][o][p]);
							} else {
								child[i].setClass(i, o, p, p2.getTimetable()[i][o][p]);
							}
						}
					}
				}
			}
			for (int i = 0; i < Data.daysPerWeek; i++) {
				int j = random.nextInt(1);
				for (int o = 0; o < Data.periodsPerDay; o++) {
					for (int p = 0; p < Data.rooms.size(); p++) {
						if (j == 0) {
							child[i].setClass(i, o, p, p1.getTimetable()[i][o][p]);
						} else {
							child[i].setClass(i, o, p, p2.getTimetable()[i][o][p]);
						}
					}
				}
			} 
		}
		return child;
	}
	public Chromosome[] selection() {
		Set<Chromosome> set=new HashSet<>();
		Chromosome[] fitest=new Chromosome[10];
		for(int i=0;i<10;i++) {
			Chromosome minfit = null;
			int minifit=100000;
			for(int o =0;o<this.getChromosomes().length;o++) {
				if(this.getChromosomes()[o].getFitness()<minifit && set.add(this.getChromosomes()[o])==true) {
					minfit=this.getChromosomes()[o];
					minifit=this.getChromosomes()[o].getFitness();
				}
			}
			set.add(minfit);
			fitest[i]=minfit;
		}
		
		return fitest;
	}
	public void mutation() {
		Random random=new Random();
		for(int i=0;i<this.getChromosomes().length;i++) {
			int p=random.nextInt(100);
			if(p==1) {
				int a=random.nextInt(Data.daysPerWeek);
				int b=random.nextInt(Data.periodsPerDay);
				int c=random.nextInt(Data.rooms.size());
				while(this.getChromosomes()[i].getTimetable()[a][b][c].getGroupe()==null) {
					a=random.nextInt(Data.daysPerWeek);
					b=random.nextInt(Data.periodsPerDay);
					c=random.nextInt(Data.rooms.size());
				}
				boolean j=random.nextBoolean();
				if (j==true) {
					int d=random.nextInt(Data.daysPerWeek);
					int e=random.nextInt(Data.periodsPerDay);
					int f=random.nextInt(Data.rooms.size());
					if(this.getChromosomes()[i].getTimetable()[d][e][f].getGroupe()==null) {
						this.getChromosomes()[i].getTimetable()[d][e][f].setGroupe(this.getChromosomes()[i].getTimetable()[a][b][c].getGroupe());
						this.getChromosomes()[i].getTimetable()[d][e][f].setInstructor(this.getChromosomes()[i].getTimetable()[a][b][c].getInstructor());
						this.getChromosomes()[i].getTimetable()[d][e][f].setModule(this.getChromosomes()[i].getTimetable()[a][b][c].getModule());
						this.getChromosomes()[i].getTimetable()[a][b][c].setInstructor(null);
						this.getChromosomes()[i].getTimetable()[a][b][c].setGroupe(null);
						this.getChromosomes()[i].getTimetable()[a][b][c].setModule(null);
					}else {
						Instructor i1=this.getChromosomes()[i].getTimetable()[d][e][f].getInstructor();
						Module m1=this.getChromosomes()[i].getTimetable()[d][e][f].getModule();
						Group g1=this.getChromosomes()[i].getTimetable()[d][e][f].getGroupe();
						this.getChromosomes()[i].getTimetable()[d][e][f].setGroupe(this.getChromosomes()[i].getTimetable()[a][b][c].getGroupe());
						this.getChromosomes()[i].getTimetable()[d][e][f].setInstructor(this.getChromosomes()[i].getTimetable()[a][b][c].getInstructor());
						this.getChromosomes()[i].getTimetable()[d][e][f].setModule(this.getChromosomes()[i].getTimetable()[a][b][c].getModule());
						this.getChromosomes()[i].getTimetable()[a][b][c].setInstructor(i1);
						this.getChromosomes()[i].getTimetable()[a][b][c].setGroupe(g1);
						this.getChromosomes()[i].getTimetable()[a][b][c].setModule(m1);
					}
				}else {
					//change instructor
					this.getChromosomes()[i].getTimetable()[a][b][c].setInstructor(
							this.getChromosomes()[i].getTimetable()[a][b][c].getModule().getInstructors().get(random.nextInt(
									this.getChromosomes()[i].getTimetable()[a][b][c].getModule().getInstructors().size())));
					
				}
			}
		}
	}
	public void nextgen() {
		ArrayList<Chromosome> newgene=new ArrayList<>();
		Chromosome[] selected=new Chromosome[10];
		selected=this.selection();
		Chromosome[] c1=new Chromosome[10];
		Chromosome[] c2=new Chromosome[10];
		Chromosome[] c3=new Chromosome[10];
		Chromosome[] c4=new Chromosome[10];
		Chromosome[] c5=new Chromosome[10];
		c1=this.crossover(selected[0], selected[1]);
		c2=this.crossover(selected[2], selected[3]);
		c3=this.crossover(selected[4], selected[5]);
		c4=this.crossover(selected[6], selected[7]);
		c5=this.crossover(selected[8], selected[9]);
		for (int i=0;i<c1.length;i++) {
			newgene.add(c1[i]);
		}
		for(int i=0;i<c2.length;i++) {
			newgene.add(c2[i]);
		}
		for(int i=0;i<c3.length;i++) {
			newgene.add(c3[i]);
		}
		for(int i=0;i<c4.length;i++) {
			newgene.add(c4[i]);
		}
		for(int i=0;i<c5.length;i++) {
			newgene.add(c5[i]);
		}
		this.setChromosomes(newgene.toArray(this.getChromosomes()));
		this.mutation();
		for(int i=0;i<this.getChromosomes().length;i++) {
			this.getChromosomes()[i].calFitness();
		}
	}
}
