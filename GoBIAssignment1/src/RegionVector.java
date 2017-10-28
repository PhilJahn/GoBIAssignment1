import java.util.Vector;

public class RegionVector {


	private Vector<Integer> region;

	public RegionVector(int x1, int x2){
		region.add(x1);
		region.add(x2);
		region.sort((a,b) -> Integer.compare(a,b));
	}
	
	public RegionVector(Vector<Integer> region){
		this.region = region;
		region.sort((a,b) -> Integer.compare(a,b));
	}
	
	public Vector<Integer> getRegion(){
		return null;
	}
	
	public RegionVector merge(RegionVector rv){
		Vector<Integer> newregion = (Vector<Integer>) region.clone();
		newregion.addAll(rv.getRegion());
		RegionVector mix = new RegionVector(newregion);
		return mix;
	}
}
