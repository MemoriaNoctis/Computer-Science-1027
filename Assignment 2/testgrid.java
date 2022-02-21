
public class testgrid {
	public static void main (String[] args) {
	
		LinkedGrid<Integer> intGrid = new LinkedGrid<Integer>(5, 3);
	
		if (intGrid.getWidth() == 5 && intGrid.getHeight() == 3) {
			for (int i  = 0; i < 5; i++) {
				for (int j = 0;j<3;j++) {
					System.out.print(intGrid.getElement(i, j).getElement());
				}
			}
		}
	}

}
