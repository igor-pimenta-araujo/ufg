from django.contrib import admin

from .models import Curso
from .models import Candidato

admin.site.register(Curso)
admin.site.register(Candidato)

# Register your models here.
