#ifndef LISTA_H_INCLUDED
#define LISTA_H_INCLUDED
#include "NoFila.h"

struct fila{
    NoFila* ini;
    NoFila* fim;
};

typedef struct fila Fila;

Fila* alocaFila();
int desenfilera(Fila* f);
void enfilera(Fila* f, No* no);
No* consultaInicioFila(Fila* f);
int filaVazia(Fila* f);

#endif // LISTA_H_INCLUDED
