from django import forms
from django.shortcuts import render, redirect, get_object_or_404
from .models import Clienti, Proiecte,ClientiProiecte
from .forms import ClientiForm, ProiecteForm, ClientiProiecteForm

def display_data(request):
    context = {
        'clienti':Clienti.objects.all(),
        'proiecte':Proiecte.objects.all(),
        'clienti_proiecte':ClientiProiecte.objects.all(),
        }
    return render(request, 'app/display_data.html',context)

def home(request):
    return render(request, 'app/home.html')
def add_client(request):
    if request.method == "POST":
        form = ClientiForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect("add_client")
    else:
        form = ClientiForm()

    return render(request, "app/add_clienti.html", {"form": form})


def add_proiect(request):
    if request.method == "POST":
        form = ProiecteForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect("add_proiect")
    else:
        form = ProiecteForm()

    return render(request, "app/add_proiecte.html", {"form": form})

def add_client_proiect(request):
    if request.method == "POST":
        form = ClientiProiecteForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect("add_client_proiect")
    else:
        form = ClientiProiecteForm()

    return render(request, "app/clientiproiecte.html", {"form": form})

def manage_database(request):
    clienti = Clienti.objects.all()
    proiecte = Proiecte.objects.all()
    assignments = ClientiProiecte.objects.all()
    return render(request, 'app/manage_database.html', {
        'clienti': clienti,
        'proiecte': proiecte,
        'assignments': assignments
    })

def delete_client(request, id):
    client = get_object_or_404(Clienti, id_client = id)
    client.delete()
    return redirect('display_data')

def delete_project(request, id):
    client = get_object_or_404(Proiecte, id_proiect = id)
    client.delete()
    return redirect('display_data')

def delete_assignment(request, id):
    assignment = get_object_or_404(ClientiProiecte, id_rol=id)
    assignment.delete()
    return redirect('manage_database')

def modify_data(request):
    clienti = Clienti.objects.all()
    proiecte = Proiecte.objects.all()
    assignment = ClientiProiecte.objects.all()
    return render(request, 'app/modify_data.html', {
        'clienti': clienti,
        'proiecte': proiecte,
        'assignment': assignment
    })

def edit_client(request, id):
    client = get_object_or_404(Clienti, id_client=id)
    form = ClientiForm(request.POST or None, instance=client)
    if form.is_valid():
        form.save()
        return redirect('display_data')
    return render(request, 'app/edit_form.html', {'form': form})

def edit_project(request, id):
    proiect = get_object_or_404(Proiecte, id_proiect=id)
    form = ProiecteForm(request.POST or None, instance=proiect)
    if form.is_valid():
        form.save()
        return redirect('display_data')
    return render(request, 'app/edit_form.html', {'form': form})

def edit_assignment(request, id):
    assignment = get_object_or_404(ClientiProiecte, id_rol = id)
    form = ClientiProiecteForm(request.POST or None, instance = assignment)
    if form.is_valid():
        form.save()
        return redirect('display_data')
    return render(request, 'app/edit_form.html', {'form': form})