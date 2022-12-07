package de.vinstee.aoc._07;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Element
{
    private final Folder parent;
    private final List<Element> children = new ArrayList<>();

    public Folder(String name, Folder parent)
    {
        super(name);
        this.parent = parent;
    }

    public Folder goUpFolder()
    {
        return this.parent;
    }

    public Folder changeFolder(String name)
    {
        for (Element e : this.children)
            if (e instanceof Folder f && f.getName().equals(name))
                return f;

        throw new IllegalStateException();
    }

    public void addChild(Element e)
    {
        this.children.add(e);
    }

    public int getSize()
    {
        int combinedSize = 0;

        for (Element e : this.children)
            combinedSize += e.getSize();

        return combinedSize;
    }

    public List<Folder> getAllFolders()
    {
        List<Folder> folderList = new ArrayList<>();

        folderList.add(this);

        for (Element e : children)
            if (e instanceof Folder f)
                folderList.addAll(f.getAllFolders());

        return folderList;
    }
}
