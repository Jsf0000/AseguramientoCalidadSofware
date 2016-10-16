/*
 * 
 */
package Controlador;

import Model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Dto.
 */
public class Dto {
	
	/** The direccion video. */
	private String direccionVideo;
	
	/** The direccion cortes. */
	private String direccionCortes;
	
	/** The direccion gt. */
	private String direccionGt;
	
	/** The delta. */
	private int delta;
	
	/** The cuts. */
	private Cut cuts;
	
	
	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion()
	{
		return direccionVideo;
	}
	
	
	
	/**
	 * Gets the direccion C.
	 *
	 * @return the direccion C
	 */
	public String getDireccionC()
	{
		return direccionCortes;
	}
	
	/**
	 * Gets the delta.
	 *
	 * @return the delta
	 */
	public int getDelta()
	{
		return delta;
	}
	
	/**
	 * Gets the cut.
	 *
	 * @return the cut
	 */
	public Cut getCut()
	{
		return cuts;
	}
	
	/**
	 * Gets the dir gt.
	 *
	 * @return the dir gt
	 */
	public String getDirGt()
	{
		return direccionGt;
	}
	
	/**
	 * Sets the dir gt.
	 *
	 * @param pdirGt the new dir gt
	 */
	public void setDirGt(String pdirGt)
	{
		 direccionGt = pdirGt;
	}
	
	/**
	 * Sets the direccion video.
	 *
	 * @param pdireccion the new direccion video
	 */
	public void setDireccionVideo(String pdireccion)
	{
		direccionVideo = pdireccion;
	}
	
	/**
	 * Sets the direccion C.
	 *
	 * @param pdireccioncortes the new direccion C
	 */
	public void setDireccionC(String pdireccioncortes)
	{
		direccionCortes = pdireccioncortes;
	}
	
	/**
	 * Sets the delta.
	 *
	 * @param pdelta the new delta
	 */
	public void setDelta(int pdelta)
	{
		delta = pdelta;
	}
	
	/**
	 * Sets the cut.
	 *
	 * @param pcuts the new cut
	 */
	public void setCut(Cut pcuts)
	{
		cuts = pcuts;
	}
	
	
	
	
	
	
	
}
