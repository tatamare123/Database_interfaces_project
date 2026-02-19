from django.contrib import admin
from .models import Clienti, Proiecte, ClientiProiecte 
admin.site.register(Clienti)
admin.site.register(Proiecte)
admin.site.register(ClientiProiecte)