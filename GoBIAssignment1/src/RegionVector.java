import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class RegionVector {


	private Vector<Region> regions;

	public RegionVector(int x1, int x2){
		regions.add(new Region(x1,x2));
		regions.sort((a,b) -> Integer.compare(a.getStart(),b.getStart()));
	}
	
	public RegionVector(Vector<Region> region){
		this.regions = region;
		regions.sort((a,b) -> Integer.compare(a.getStart(),b.getStart()));
	}
	
	public Vector<Region> getRegions(){
		return regions;
	}
	
	public RegionVector merge(RegionVector rv){

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
        return new RegionVector(resultV);
	}
	
	class RegionComparator implements Comparator<Region>
	{
	    public int compare(Region x1, Region x2)
	    {
	        return x1.getStart() - x2.getStart();
	    }
	}
}
