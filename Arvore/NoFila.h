#ifndef NOFILA_H_INCLUDED
#define NOFILA_H_INCLUDED

typedef struct NoFila NoFila;

struct NoFila{
    No* no;
    NoFila* prox;
};



NoFila* alocarNoFila();
void desalocaNoFila(NoFila* nofila);

#endif // NOFILA_H_INCLUDED
