<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class directorioModel extends Model
{
    protected $table = 'directorio';

    protected $primaryKey = 'codigoEntrada';

    protected $fillable = [
        'codigoEntrada',
        'nombre',
        'apellido',
        'correo',
        'telefono'
    ];

    public $timestamps = false;

    use HasFactory;
}
