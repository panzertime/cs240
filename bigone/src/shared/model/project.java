package shared.model;

import java.util.*;
import java.io.*;
import shared.model.batch;
import shared.model.field;

/**
 * a project, which has fields and batches, organizes
 * different types of indexable records.
 */
public class project implements Serializable {
	
	private String sImg;
	private String name;
	private int ID;
	private ArrayList<field> fields = new ArrayList<field>();
	private LinkedList<batch> batches;
	private int y;
	private int recs;
	private int h;
	
	/**
	 * Construct a new project
	*	@param image sample image URL
	*	@param title project name
	*	@param pID project ID (zero until generated by DB)
	* 	@param y_coord y-coordinate of first field
	* 	@param numRecords number of records in project
	* 	@param height height of each field
	*/
	public project(String image, String title, int pID,
			int y_coord, int height, int numRecords){
		sImg = image;
		name = title;
		ID = pID;
		y = y_coord;
		h = height;
		recs = numRecords;		
	}

	/**
	*	add fields
	*	@param f field to add
	*/
	public void addField(field f){
		fields.add(f);
	}

	/**
	*	add batches
	*	@param b batch to add
	*/
	public void addBatch(batch b){
		batches.add(b);
	}
	
	/**
	 * reveal an image, which is representative of the batches
	 * in this project.
	* 	@return image url
	*/
	public String getImage(){
		return sImg;
	}

	/**
	 * reveal this project's name (or title)
	*	@return title
	*/
	public String getTitle(){
		return name;
	}
	
	/**
	 * reveal the project's globally-unique ID
	*	@return project ID
	*/
	public int getID(){
		return ID;
	}
	
	/**
	 * set the project ID (generated by the DB)
	 * @param i the ID
	 */
	public void setID(int i){
		ID = i;
	}

//		not used in this incarnation, will be handy with the client
//	/**
//	*	give the "next" batch back
//	*	@return a batch from the project
//	*/
//	public LinkedList<batch> getBatches(){
//		return batches;
//	}
//
//	/**
//	*	give the "next" field back
//	*	@return a field from the project
//	*/
//	public LinkedList<field> getFields(){
//		return fields;
//	}
	
	/**
	 * reveal the first y-coordinate
	 * @return int representing y-coord
	 */
	public int getYCoord(){
		return y;
	}
	
	/**
	 * reveal record height of batches in this project
	 * @return int representing the record height
	 */
	public int getHeight(){
		return h;
	}
	
	/**
	 * reveal how many records (rows) batches in this project has
	 * @return the number of records this project should have
	 */
	public int getRecordQuantity(){
		return recs;
	}	

	/**
	 * print the fields
	 * String that has all the field info in it
	 * @param prefix to append to URLs
	 * @return String of formatted field vals
	 */
	public String printFields(String prefix){
		StringBuilder sb = new StringBuilder();
		for(field t : fields){
			sb.append(t.getID());
			sb.append("\n");
			sb.append(t.getNumber());
			sb.append("\n");
			sb.append(t.getTitle());
			sb.append("\n");
			sb.append(prefix + t.getHelp());
			sb.append("\n");
			sb.append(t.getXCoord());
			sb.append("\n");
			sb.append(t.getWidth());
			sb.append("\n");
			if(!t.getVals().equals("")){
				sb.append(prefix);
				sb.append(t.getVals());
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(!(o instanceof project)){
			return false;
		}
		
		project c = (project) o;
		
		return (
			sImg.equals(c.getImage()) &&
			name.equals(c.getTitle()) &&
			(ID == c.getID()) &&
			(recs == c.getRecordQuantity()) &&
			(y == c.getYCoord()) &&
			(h == c.getHeight())
		);
	}	
}
