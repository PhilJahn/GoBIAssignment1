import java.util.ArrayList;

import AugmentedTree.IntervalTree;

public class Transcript extends RegionVector{
	
	private IntervalTree<Region> introns; 

	public Transcript(int start, int stop, Annotation annotation)  {
		super(start, stop, annotation);
	}
	
	public int getProtNum(){
		ArrayList<Annotation> annos = new ArrayList<Annotation>();
		for(Region r: this.getRegionsTree()){
			Annotation anno = r.getAnnotation();
			if(!annos.contains(anno)){
				annos.add(anno);
			}
		}
		return annos.size();
		
	}
	
	public void setIntrons(){
		introns = this.invert().getRegionsTree();
	}
	
	public IntervalTree<Region> getIntrons(){
		return introns;
	}
	
	public String toString(){
		return "Transcript: " + super.toString();
	}
	
}
