package com.indooratlas.mapcreator.data;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class MapMatrix
 implements Serializable
{

 public MapMatrix(com.indooratlas.communication.cmn.Matrix matrix)
 {
 	mColsNum = 0;
 	mRowsNum = 0;
     MF_CLASS107_e446 = Collections.emptyList();
     if(matrix.hasCols())
     	setColsNum(matrix.getCols());
     if(matrix.hasRows())
     	setRowsNum(matrix.getRows());
     MF_CLASS107_e446 = matrix.getValueList();
 }

 public MapMatrix setColsNum(int i)
 {
 	mHasCols = true;
     mColsNum = i;
     return this;
 }

 public MapMatrix setRowsNum(int i)
 {
     mHasRows = true;
     mRowsNum = i;
     return this;
 }

 private static final long serialVersionUID = 1L;
 private boolean mHasCols;
 private boolean mHasRows;
 private int mColsNum;
 private int mRowsNum;
 private List MF_CLASS107_e446;
}
