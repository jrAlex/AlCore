package jrAlex.core.world;

import jrAlex.core.world.world_objects.WorldObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 10/31/2016.
 */

public class WorldObjectArray<E extends WorldObject> extends WorldObjectContainer<E>
{
	private List<E> array;

	public WorldObjectArray(int x, int y, int width, int height, WorldObjectContainer container)
	{
		super(x, y, width, height, container);
		array = new LinkedList<>();
	}

	@Override
	public void addObjectAt(int x, int y, E e)
	{
		e.setLocation(x, y);
		array.add(e);
	}

	@Override
	public E getObjectAt(int x, int y)
	{
		if (contains(x, y))
		{
			for (E e : array)
			{
				if (e.contains(x, y))
				{
					return e;
				}
			}
		}

		return null;
	}

	@Override
	public List<E> getObjectsAt(Bound b)
	{
		List<E> foundObjects = new LinkedList<>();

		if (contains(b))
		{
			for (E e : array)
			{
				if (e.intersects(b))
				{
					foundObjects.add(e);
				}
			}
		}

		return foundObjects;
	}

	@Override
	public E removeObjectAt(int x, int y)
	{
		if (contains(x, y))
		{
			E oldObject = getObjectAt(x, y);
			array.remove(oldObject);
			return oldObject;
		}

		return null;
	}

	public List<E> getObjects()
	{
		return array;
	}
}
