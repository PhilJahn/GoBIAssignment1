import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class RegionVector {
	
	public static void main(String[] args) {
		RegionVector rv1 = new RegionVector(1,5);
		RegionVector rv2 = new RegionVector(6,7);
		RegionVector rv3 = new RegionVector(4,10);
		RegionVector rv = rv1.merge(rv2).invert();
		System.out.println(rv.getRegions());
	}


	private Vector<Region> regions;

	public RegionVector(int x1, int x2){
		regions = new Vector<Region>();
		regions.add(new Region(x1,x2));
		regions.sort((a,b) -> Integer.compare(a.getStart(),b.getStart()));
	}
	
	public RegionVector(Vector<Region> region){
		this.regions = region;
		if(regions.size() > 1){
			regions.sort((a,b) -> Integer.compare(a.getStart(),b.getStart()));
			this.merge();
		}
	}
	
	public Vector<Region> getRegions(){
		return regions;
	}
	
	public void merge(){

		regions.sort(new RegionComparator());

        Region r = regions.get(0);
        int start = r.getStart();
        int stop = r.getStop();

        Vector<Region> resultV = new Vector<Region>();

        for (int i = 1; i < regions.size(); i++) {
            Region current = regions.get(i);
            if (current.getStart() <= stop) {
                stop = Math.max(current.getStop(), stop);
            } else {
                resultV.add(new Region(start, stop));
                start = current.getStart();
                stop = current.getStop();
            }
        }

        resultV.add(new Region(start, stop));
        regions = resultV;
	}
	
	public RegionVector merge(RegionVector rv){

		regions.addAll(rv.getRegions());
		RegionVector results = new RegionVector(regions); 
		
		results.merge();
		
        return results;
	}
	
	public RegionVector subtract(RegionVector rv){
		
		regions.sort(new RegionComparator());
		
		Vector<Region> sub = rv.getRegions();
		sub.sort(new RegionComparator());

        Vector<Region> resultV = new Vector<Region>();
        
        int j = 0;
        int i = 0;
        while (i < regions.size()) {
            Region current = regions.get(i);
            int start = current.getStart();
            int stop = current.getStop();
            Region cursub = sub.get(j);
            int substart = cursub.getStart();
            int substop = cursub.getStop();
            while(substop-1 < start && j < sub.size()){
            	j++;
            	if(j < sub.size()){
            		cursub = sub.get(j);
            		substart = cursub.getStart();
            		substop = cursub.getStop();
            	}
            }
            while(substop < stop && substop-1 >= start && j < sub.size()){
            	substart = cursub.getStart();
            	substop = cursub.getStop();
            	if (start < substart) {
            		resultV.add(new Region(start, substart));
            		start = substop;
            		j++;
            		
            	}
            	else{
            		start = substop;
            		j++;
            	}
            	if(j < sub.size()){
            		cursub = sub.get(j);
            		substart = cursub.getStart();
                	substop = cursub.getStop();
            	}
            }
            if(substop >= stop && substart < stop && substart > start){
            	resultV.add(new Region(start, substart));
            }
            else if(substop >= stop && substart <= start){
            	
            }
            else{
            	resultV.add(new Region(start,stop));
            }
            i++;
        }
        return new RegionVector(resultV);
		
	}
	
	public int length(){
		if(regions.size() > 0){
			return (regions.get(regions.size()-1).getStop() - regions.get(0).getStart());
		}
		else{
			return 0;
		}
	}
	
	public RegionVector invert(){
		Vector<Region> resultV = new Vector<Region>();
		for(int i = 0; i < regions.size()-1; i++){
			resultV.add(new Region(regions.get(i).getStop(), regions.get(i+1).getStart()));
		}
		return new RegionVector(resultV);
	}
	
	public int coveredLength(){
		int l = 0;
		for(int i = 0; i < regions.size(); i++ ){
			l += regions.get(i).length();
		}
		return l;
	}
	
	class RegionComparator implements Comparator<Region>
	{
	    public int compare(Region x1, Region x2)
	    {
	        return x1.getStart() - x2.getStart();
	    }
	}
}
