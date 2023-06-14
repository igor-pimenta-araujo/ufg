from django.db import models


class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')


class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)

class Curso(models.Model):
    nome = models.CharField(max_length=100)
    descricao = models.TextField()
    carga_horaria = models.IntegerField()
    def __str__(self):
        return self.nome

class Candidato(models.Model):
    nome = models.CharField(max_length=60)
    sexo = models.CharField(max_length=1)
    data_nasc = models.DateField()
    cargo_pretendido = models.CharField(max_length=25)
    texto_curriculo = models.TextField()
    def __str__(self):
        return self.nome