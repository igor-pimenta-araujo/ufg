from django.http import HttpResponse
from django.shortcuts import redirect, render
from datetime import datetime

from .models import Curso
from .models import Candidato

def index(request):
    latest_question_list = Curso.objects.order_by('nome')[:5]
    context = {'latest_question_list': latest_question_list}
    return render(request, 'index.html', context)

def list(request):
    cursos = Curso.objects.order_by('nome')[:5]
    context = {'cursos': cursos}
    return render(request, 'curso/listTable.html', context)

def list_candidates(request):
    candidatos = Candidato.objects.order_by('nome')[:5]
    context = {'candidatos': candidatos}
    return render(request, 'candidato/listTable.html', context)

def detail(request, question_id):
    curso = Curso.objects.get(pk=question_id)
    context = {'curso': curso}
    return render(request, 'curso/detail.html', context)

def update_candidate(request, id):
    candidato = Candidato.objects.get(pk=id)
    context = {'candidato': candidato}
    return render(request, 'candidato/update.html', context)

def add_candidate(request):
    return render(request, 'candidato/inserir.html')

def list_candidates(request):
    candidatos = Candidato.objects.order_by('nome')[:5]
    context = {'candidatos': candidatos}
    return render(request, 'candidato/listTable.html', context)

def detail_candidate(request, id):
    candidato = Candidato.objects.get(pk=id)
    context = {'candidato': candidato}
    return render(request, 'candidato/detail.html', context)

def delete_candidate(request, id):
    candidato = Candidato.objects.get(pk=id)
    candidato.delete()
    return redirect('list')

def add_candidature(request):
    candidato = Candidato(
        nome=request.POST['nome'],
        sexo=request.POST['sexo'],
        data_nasc=request.POST['data_nascimento'],
        cargo_pretendido=request.POST['cargo_pretendido'],
        texto_curriculo=request.POST['texto_curriculo']
    )
    candidato.save()
    return redirect('list')

def atualizar_candidato(request, id):
    if request.method == 'GET':
        candidato = Candidato.objects.get(pk=id)
        context = {'candidato': candidato, 'data': candidato.data_nasc.isoformat()}
        return render(request, 'candidato/update.html', context)

    if request.method == 'POST':
        Candidato.objects.filter(pk=id).update(
            nome=request.POST['nome'], sexo=request.POST['sexo'], 
            data_nasc=request.POST['data_nascimento'], 
            cargo_pretendido=request.POST['cargo_pretendido'],
            texto_curriculo=request.POST['texto_curriculo'])
        return redirect('list')