/*
 * File: LinkedHeadTailList.java
 */

/**
 * Class implementing the HeadTailList interface.
 *
 * @author J. Andrew Whitford Holey
 * @version October 16, 2013
 */
public class LinkedHeadTailList<ElementType> implements HeadTailList<ElementType>
{
  private ElementType head;
  private HeadTailList<ElementType> tail;


  public LinkedHeadTailList() {
    this.head = null;
    this.tail = null;
  }


  public LinkedHeadTailList(ElementType head, HeadTailList<ElementType> tail)
  {
    this.head = head;
    this.tail = tail;
  }


  /**
   * Returns true if this list is empty
   *
   * @return true if this list is empty
   */
  public boolean isEmpty()
  {
    return this.tail == null;
  }


  /**
   * Returns the first element of this HeadTailList, or null if this list is
   * empty.
   * Equivalent to the Lisp car function.
   *
   * @return the first element of this HeadTailList, or null if this list is
   * empty
   */
  public ElementType head()
  {
    return this.head;
  }


  /**
   * Returns the tail of this HeadTailList, that is, a list consisting of all
   * the elements in this list except the first element in the same order as the
   * elements of this list; returns null if this list is empty.
   * Equivalent to the Lisp cdr function.
   *
   * @return the tail of this HeadTailList, or null if this list is empty
   */
  public HeadTailList<ElementType> tail()
  {
    return this.tail;
  }
}
