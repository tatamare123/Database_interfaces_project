from django.urls import path
from . import views

urlpatterns = [
    path("", views.home, name="home"),
    path("add_client/", views.add_client, name="add_client"),
    path("add_proiect/", views.add_proiect, name="add_proiect"),
    path("add_client_proiect/", views.add_client_proiect, name="add_client_proiect"),
    path("display/",views.display_data, name = "display_data"),
    path('delete_client/<int:id>/', views.delete_client, name = 'delete_client'),
    path('delete_project/<int:id>/', views.delete_project, name = 'delete_project'),
    path('manage/', views.manage_database, name='manage_database'),
    path('delete_assignment/<int:id>/', views.delete_assignment, name='delete_assignment'),
    path('modify-data/', views.modify_data, name='modify_data'),
    path('edit-client/<int:id>/', views.edit_client, name='edit_client'),
    path('edit-project/<int:id>/', views.edit_project, name='edit_project'),
    path('edit-assignment/<int:id>/', views.edit_assignment, name='edit_assignment'),
    
]