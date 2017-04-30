/*
    Unimozer
    Unimozer intends to be a universal modelizer for Java™. It allows the user
    to draw UML diagrams and generates the relative Java™ code automatically
    and vice-versa.

    Copyright (C) 2009  Bob Fisch

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or any
    later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package lu.fisch.unimozer.visitors;

import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.QualifiedNameExpr;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.util.Iterator;
import java.util.Vector;
import lu.fisch.unimozer.Package;

/**
 *
 * @author robertfisch
 */
public class InterfaceVisitor extends VoidVisitorAdapter
{

    private String name = Package.DEFAULT;
    private boolean stop = true;

    private Vector<String> implementsClasses = new Vector<String>();

    public Vector<String> getImplementsClasses()
    {
        return implementsClasses;
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object arg)
    {
        if(!stop)
            name+=n.getName();

        if (n.getImplements() != null)
        {   
            stop=false;
            for (Iterator<ClassOrInterfaceType> i = n.getImplements().iterator(); i.hasNext();)
            {
                ClassOrInterfaceType c = i.next();
                name="";
                c.accept(this, arg);
                implementsClasses.add(name);
            }
            stop=true;
        }
    }

    public void visit(ClassOrInterfaceType n, Object arg)
    {
        if (n.getScope() != null)
        {
            n.getScope().accept(this, arg);
            if(!stop) name+=".";

        }
        if(!stop) name+=n.getName();

    }

    @Override
    public void visit(NameExpr n, Object arg)
    {
        if(!stop)
            name+=n.getName();
    }

    @Override
    public void visit(QualifiedNameExpr n, Object arg)
    {
        if(!stop)
        {
            n.getQualifier().accept(this, arg);
            name+="."+n.getName();
        }
    }


}
