<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class contactosModel extends Model
{
    protected $table = 'contactos';

    protected $primaryKey = 'id';

    protected $fillable = [
        'condigoEntrada',
        'nombre',
        'apellido',
        'telefono'
    ];

    public $timestamps = false;

    use HasFactory;
}
