import java.util.ArrayList;
import AugmentedTree.Interval;
import AugmentedTree.IntervalTree;

public class ExonSkip implements Interval{

	private ArrayList<String> sv_prot;
	private ArrayList<String> wt_prot;
	
	private int start;
	private int stop;
	private ArrayList<Region> wt_introns;
	
	private int minEx;
	private int maxEx;
	
	private int minBase;
	private int maxBase;
	
	private ArrayList<Transcript> sv_trans;
	private ArrayList<Transcript> wt_trans;
	
	
	public ExonSkip(ArrayList<String> sv_prot, ArrayList<Region> introns, ArrayList<String> wt_prot, ArrayList<Transcript> sv_trans, ArrayList<Transcript> wt_trans) {
		this.sv_prot = sv_prot;
		this.wt_prot = wt_prot;
		this.sv_trans = sv_trans;
		this.wt_trans = wt_trans;
		
		start = introns.get(0).getStart();
		stop = introns.get(introns.size()-1).getStop();
		wt_introns = introns;
		
		this.minEx = introns.size()-1;
		this.maxEx = minEx;
		
		int istart = introns.get(0).getStop();
		int istop = 0;
		
		minBase = 0;
		
		
		for( int i = 1; i < introns.size()-1; i++){
			istop = introns.get(i).getStart();
			minBase += istart-istop;
			istart = introns.get(i).getStop(); 
		}
		istop = introns.get(introns.size()-1).getStart();
		minBase += istart-istop;
		maxBase = minBase;
		
	}
	
	public void merge(ExonSkip e){
		if(start < stop){
			start = Math.min(e.getStart(),start);
			stop = Math.max(e.getStop(),stop);
		}
		else{
			start = Math.max(e.getStart(),start);
			stop = Math.min(e.getStop(),stop);
		}
		
		minEx = Math.min(minEx, e.getMinEx());
		maxEx = Math.max(maxEx, e.getMaxEx());
		
		minBase = Math.min(minBase, e.getMinBase());
		maxBase = Math.max(maxBase, e.getMaxBase());
		
		ArrayList<String> esv = e.getSVProt();
		ArrayList<String> ewt = e.getWTProt();
		ArrayList<Region> eintron = e.getWTIntrons();
		ArrayList<Transcript> esvt = e.getSVTrans();
		ArrayList<Transcript> ewtt = e.getWTTrans();
		
		for(int i = 0; i < esv.size(); i++){
			if(!sv_prot.contains(esv.get(i))){
				sv_prot.add(esv.get(i));
			}
		}
		
		for(int i = 0; i < ewt.size(); i++){
			if(!wt_prot.contains(ewt.get(i))){
				wt_prot.add(ewt.get(i));
			}
		}
		
		for(int i = 0; i < esvt.size(); i++){
			if(!sv_trans.contains(esvt.get(i))){
				sv_trans.add(esvt.get(i));
			}
		}
		
		for(int i = 0; i < ewtt.size(); i++){
			if(!wt_trans.contains(ewtt.get(i))){
				wt_trans.add(ewtt.get(i));
			}
		}
		
		IntervalTree<Region> mergeTree = new IntervalTree<Region>();
		mergeTree.addAll(wt_introns);
		
		for(int i = 0; i < eintron.size(); i++){
			Region curewt = eintron.get(i);
			if(!wt_introns.contains(curewt)){
					
				mergeTree.getIntervalsSpannedBy(curewt.getStart(), curewt.getStop(), )
					if(curwt.getStart() == curewt.getStart()){
						if(curwt.length() > curewt.length()){
							eintron.set(j, curewt);
							i++;
							eintron.add(j+1, eintron.get(i));
						}
					}
				}
			}
		}
	}
	
	public ArrayList<String> getSVProt(){
		return sv_prot;
	}
	
	public ArrayList<String> getWTProt(){
		return wt_prot;
	}
	
	public ArrayList<Transcript> getSVTrans(){
		return sv_trans;
	}
	
	public ArrayList<Transcript> getWTTrans(){
		return wt_trans;
	}
	
	public int getStart(){
		return start;
	}
	
	public int getStop(){
		return stop;
	}
	
	public ArrayList<Region> getWTIntrons(){
		return wt_introns;
		
	}
	
	public int getMinEx(){
		return minEx;
	}
	
	public int getMaxEx(){
		return maxEx;
	}
	
	public int getMinBase(){
		return minBase;
	}
	
	public int getMaxBase(){
		return maxBase;
	}
	
	public String toString(){
		return start + ":" + stop + " sv: " + sv_prot.toString() + " wt: " + wt_prot.toString();
	}
}
