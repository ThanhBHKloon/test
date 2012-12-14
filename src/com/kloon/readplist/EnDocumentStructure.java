package com.kloon.readplist;

import java.util.ArrayList;

public class EnDocumentStructure
{
    private int lastPageNumber; // last page in document
    private int pageCount;  // number of individual page stored in the structure (e.g., for 2 articles, would be 2)
    private boolean structureLoaded;
    ArrayList<EnPageArticleStructure> pages;
    
    public EnDocumentStructure()
    {
        
    }
    
    /**
     * @return the lastPageNumber
     */
    public int getLastPageNumber()
    {
        return lastPageNumber;
    }
    /**
     * @param lastPageNumber the lastPageNumber to set
     */
    public void setLastPageNumber(int lastPageNumber)
    {
        this.lastPageNumber = lastPageNumber;
    }
    /**
     * @return the pageCount
     */
    public int getPageCount()
    {
        return pageCount;
    }
    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }
    /**
     * @return the structureLoaded
     */
    public boolean isStructureLoaded()
    {
        return structureLoaded;
    }
    /**
     * @param structureLoaded the structureLoaded to set
     */
    public void setStructureLoaded(boolean structureLoaded)
    {
        this.structureLoaded = structureLoaded;
    }
}
