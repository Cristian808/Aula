#ifndef ARVORE_H_INCLUDED
#define ARVORE_H_INCLUDED
#include "No.h"

struct arvore{
    No* raiz;
};

typedef struct arvore Arvore;

Arvore* alocaArvore();
void desalocaArvore(Arvore* a);
void construirArvore(Arvore* a, int n);
void imprimirArvore(Arvore* a);
void colocarNosArvore(No* no, int n);
int verificaN(No* raiz, int n);
void imprimirSubArvore(No* n);
void lerString(No* no, char c[], int *cont, int t);
void lerStringArvore(Arvore* a, char[]);

#endif // ARVORE_H_INCLUDED
