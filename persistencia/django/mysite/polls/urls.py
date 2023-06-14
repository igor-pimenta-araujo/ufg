from django.urls import path

from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('list', views.list, name='list'),
    path('candidatos/listar', views.list_candidates, name='list'),
    path('<int:id>/', views.detail_candidate, name='detail-candidate'),
    path('atualizar/<int:id>/', views.atualizar_candidato, name='update-candidate'),
    path('add-candidate', views.add_candidate, name='add-candidate'),
    path('add-candidature', views.add_candidature, name='add-candidature'),
    path('delete-candidate/<int:id>', views.delete_candidate, name='delete-candidate'), 
]