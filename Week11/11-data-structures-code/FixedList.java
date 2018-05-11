// A class wrapper for a list of Strings. This version does not
// expand.
public class FixedList{
  private int size;             // number of elements that have been added
  private String[] data;        // contents of the array

  // Create the array backing the fixed list
  public FixedList(int maxSize){
    this.size = 0;
    this.data = new String[maxSize];
  }

  // Return how many elements are in the list
  public int size(){
    return this.size;
  }

  // Return element i of the list. Check that the index is in bounds
  // (greater than or equalt to 0 and less than the list size)
  public String get(int i){
    if(i < 0 || i >= this.size){ // out of bounds
      throw new RuntimeException("out of bounds");
    }
    return this.data[i];
  }

  // Change element i of the list. Check that the index is in bounds
  // (greater than or equalt to 0 and less than the list size)
  public void set(int i, String x){
    if(i < 0 || i >= this.size){ // out of bounds
      throw new RuntimeException("out of bounds");
    }
    this.data[i] = x;
  }

  // Add the given string to the list at the end. If there is not
  // sufficient space for the addition, throw an exception
  public void add(String x){
    if(this.size >= this.data.length){ // check for space
      throw new RuntimeException("list array is full");
    }
    this.data[this.size] = x;   // add on element
    this.size++;                // increase size
  }

  public String toString(){
    if(this.size==0){
      return "[]";
    }
    String str = "[" + this.data[0];
    for(int i=1; i<this.size; i++){
      str += ", " + this.data[i];
    }
    str += "]";
    return str;
  }
}
