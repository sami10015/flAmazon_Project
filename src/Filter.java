//Sharing data class
public class Filter {
	//Indicates the type of filter for the price is selected
	private int filterNum;
	
	//These doubles are changed in the addPrice filter frame
	private double lessThanPrice;
	private double greaterThanPrice;
	private double minPrice;
	private double maxPrice;
	
	//These booleans if their corresponding checkbox in the addCategoryFilter frame is selected
	private boolean Electronics = true;
	private boolean Computers = true;
	private boolean Clothing = true;
	private boolean Music = true;
	private boolean Books = true;
	private boolean Movies = true;
	private boolean HomeGarden = true;
	private boolean Sports = true;
	private boolean Automotive = true;
	private boolean Other = true;
	
	//Indicates how many categories are selected
	private int amountSelected = 10;
	
	public Filter(){
		setFilterNum(0);
	}

	public double getLessThanPrice() {
		return lessThanPrice;
	}

	public void setLessThanPrice(double lessThanPrice) {
		this.lessThanPrice = lessThanPrice;
	}

	public double getGreaterThanPrice() {
		return greaterThanPrice;
	}

	public void setGreaterThanPrice(double greaterThanPrice) {
		this.greaterThanPrice = greaterThanPrice;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getFilterNum() {
		return filterNum;
	}

	public void setFilterNum(int filterNum) {
		this.filterNum = filterNum;
	}

	public boolean isElectronics() {
		return Electronics;
	}

	public void setElectronics(boolean electronics) {
		Electronics = electronics;
	}

	public boolean isComputers() {
		return Computers;
	}

	public void setComputers(boolean computers) {
		Computers = computers;
	}

	public boolean isClothing() {
		return Clothing;
	}

	public void setClothing(boolean clothing) {
		Clothing = clothing;
	}

	public boolean isMusic() {
		return Music;
	}

	public void setMusic(boolean music) {
		Music = music;
	}

	public boolean isBooks() {
		return Books;
	}

	public void setBooks(boolean books) {
		Books = books;
	}

	public boolean isMovies() {
		return Movies;
	}

	public void setMovies(boolean movies) {
		Movies = movies;
	}

	public boolean isHomeGarden() {
		return HomeGarden;
	}

	public void setHomeGarden(boolean homeGarden) {
		HomeGarden = homeGarden;
	}

	public boolean isSports() {
		return Sports;
	}

	public void setSports(boolean sports) {
		Sports = sports;
	}

	public boolean isAutomotive() {
		return Automotive;
	}

	public void setAutomotive(boolean automotive) {
		Automotive = automotive;
	}

	public boolean isOther() {
		return Other;
	}

	public void setOther(boolean other) {
		Other = other;
	}

	public int getAmountSelected() {
		return amountSelected;
	}

	public void setAmountSelected(int amountSelected) {
		this.amountSelected = amountSelected;
	}
}
