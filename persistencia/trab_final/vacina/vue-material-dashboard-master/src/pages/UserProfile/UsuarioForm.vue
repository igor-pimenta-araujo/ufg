<template>
  <form>
    <md-card>
      <md-card-header :data-background-color="dataBackgroundColor">
        <h4 class="title">Cadastrar Usuario</h4>
      </md-card-header>

      <md-card-content>
        <div class="md-layout">
          <div class="md-layout-item md-small-size-100 md-size-50">
            <md-field>
              <label>Nome</label>
              <md-input v-model="nome" type="text" />
            </md-field>
            <md-field>
              <label>Data de Nascimento</label>
              <md-input v-model="dataNascimento" type="date" />
            </md-field>
            <md-field>
              <label>Sexo</label>
              <md-select v-model="sexo">
                <md-option value="m"> Masculino </md-option>
                <md-option value="f"> Feminino </md-option>
              </md-select>
            </md-field>
            <md-field>
              <label>Logradouro</label>
              <md-input v-model="logradouro" type="text" />
            </md-field>
            <md-field>
              <label>Número</label>
              <md-input v-model="numero" type="text" />
            </md-field>
            <md-field>
              <label>Setor</label>
              <md-input v-model="setor" type="text" />
            </md-field>
            <md-field>
              <label>Cidade</label>
              <md-input v-model="cidade" type="text" />
            </md-field>
            <md-field>
              <label>UF</label>
              <md-select v-model="uf">
                <md-option
                  v-for="item in ufDisponiveis"
                  :key="item"
                  :value="item"
                >
                  {{ item }}
                </md-option>
              </md-select>
            </md-field>
            <md-field>
              <label>Alergias</label>
              <md-select v-model="alergias" multiple>
                <md-option
                  v-for="alergia in alergiasDisponiveis"
                  :key="alergia.id"
                  :value="alergia.id"
                >
                  {{ alergia.nome }}
                </md-option>
              </md-select>
            </md-field>
          </div>
          <div class="md-layout-item md-size-100 text-right">
            <md-button @click="cadastrarUsuario()" class="md-raised md-success">
              Cadastrar
            </md-button>
          </div>
        </div>
      </md-card-content>
    </md-card>
  </form>
</template>
<script>
export default {
  name: "usuario-form",
  props: {
    dataBackgroundColor: {
      type: String,
      default: "",
    },
  },
  data() {
    return {
      nome: "",
      dataNascimento: "",
      sexo: "",
      logradouro: "",
      numero: "",
      setor: "",
      cidade: "",
      uf: "",
      alergias: [],
      alergiasDisponiveis: [],
      ufDisponiveis: [
        "AC",
        "AL",
        "AP",
        "AM",
        "BA",
        "CE",
        "DF",
        "ES",
        "GO",
        "MA",
        "MT",
        "MS",
        "MG",
        "PA",
        "PB",
        "PR",
        "PE",
        "PI",
        "RJ",
        "RN",
        "RS",
        "RO",
        "RR",
        "SC",
        "SP",
        "SE",
        "TO",
      ],
    };
  },
  created() {
    this.getAlergias();
  },
  methods: {
    async getAlergias() {
      const response = await this.$axios.get(`http://localhost:8080/alergia`, {
        headers: {},
      });
      this.alergiasDisponiveis = response.data;
    },
    async cadastrarUsuario() {
      const response = await this.$axios.post(
        `http://localhost:8080/usuario`,
        {
          nome: this.nome,
          dataNascimento: this.dataNascimento,
          sexo: this.sexo,
          logradouro: this.logradouro,
          numero: this.numero,
          setor: this.setor,
          cidade: this.cidade,
          uf: this.uf,
          alergias: this.montaAlergias(),
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      this.$router.push("/visualizar-usuario");
    },
    montaAlergias() {
      const alergias = [];
      this.alergias.forEach((alergia) => {
        alergias.push({ id: alergia });
      });
      return alergias;
    },
  },
};
</script>
