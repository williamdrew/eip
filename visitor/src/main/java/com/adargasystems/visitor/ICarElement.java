package com.adargasystems.visitor;
interface ICarElement {
    void accept(ICarElementVisitor visitor);
}