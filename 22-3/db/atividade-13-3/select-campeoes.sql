SELECT 
	piloto.nome AS nome_piloto, 
  	corrida.data AS data_corrida, 
  	piloto_corrida.posicao AS posicao_final 
from piloto
INNER JOIN piloto_corrida ON piloto.id = piloto_corrida.id_piloto 
INNER JOIN corrida ON piloto_corrida.id_corrida = corrida.id
where piloto_corrida.posicao = 1