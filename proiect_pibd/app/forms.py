from django import forms
from .models import Clienti, Proiecte, ClientiProiecte

ROLE_CHOICES = [
    ('beneficiar', 'Beneficiar'),
    ('partener', 'Partener'),
]

class ClientiForm(forms.ModelForm):
    class Meta:
        model = Clienti
        fields = ["nume", "email", "telefon"]

class ProiecteForm(forms.ModelForm):
	class Meta:
		model = Proiecte
		fields = ["denumire","data_start", "data_final"]

class ClientiProiecteForm(forms.ModelForm):
    
    rol_client = forms.ChoiceField(
        choices=ROLE_CHOICES,
        widget=forms.Select(attrs={'class': 'form-select'})
    )

    class Meta:
        model = ClientiProiecte
        fields = ['rol_client', 'id_client', 'id_proiect']
        widgets = {
            'id_client': forms.Select(attrs={'class': 'form-select'}),
            'id_proiect': forms.Select(attrs={'class': 'form-select'}),
        }