package com.diabin.latte.compiler;

import com.squareup.javapoet.TypeSpec;

import java.util.logging.Filter;

import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

/**
 * Created by mac on 2018/5/19.
 */

public class EntryVisitor extends SimpleAnnotationValueVisitor7<Void,Void> {
    private Filter mFilter = null;
    private TypeMirror mTypeMirror = null;
    private String mPackageName = null;

    public void setFilter(Filter filter) {
        this.mFilter = filter;
    }

    @Override
    public Void visitString(String s, Void v) {
        mPackageName = s;
        return v;
    }

    @Override
    public Void visitType(TypeMirror t, Void v) {
        mTypeMirror =t;
        generateJavaCode();
        return v;
    }

    private void generateJavaCode() {
        final TypeSpec targetActivity =
                TypeSpec.classBuilder("WXEntryActivity")
                .addModifiers(Modifier.PUBLIC)
                .addModifiers(Modifier.FINAL)
    }

}
