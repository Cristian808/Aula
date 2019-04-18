#ifndef NO_H_INCLUDED
#define NO_H_INCLUDED

typedef struct no No;

struct no{
    int info;
    No* esq;
    No* dir;
    int h;
};

No* alocarNo();
void desalocarNo(No* no);

#endif // NO_H_INCLUDED

