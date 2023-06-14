<template>
  <div class="content">
    <div class="md-layout">
      <div
        class="md-layout-item md-medium-size-100 md-xsmall-size-100 md-size-100"
      >
        <md-card>
          <md-card-header data-background-color="green">
            <h3 class="md-title">
              Informações {{ usuario.sexo == "m" ? "do" : "da" }}
              {{ usuario.nome }}
            </h3>
          </md-card-header>
          <md-card-content>
            <p><strong>Nome:</strong> {{ usuario.nome }}</p>
            <p>
              <strong>Data de Nascimento:</strong> {{ usuario.dataNascimento }}
            </p>
            <p>
              <strong>Sexo:</strong>
              {{ usuario.sexo == "m" ? "Masculino" : "Feminino" }}
            </p>
            <p><strong>Logradouro:</strong> {{ usuario.logradouro }}</p>
            <p><strong>Número:</strong> {{ usuario.numero }}</p>
            <p><strong>Setor:</strong> {{ usuario.setor }}</p>
            <p><strong>Cidade:</strong> {{ usuario.cidade }}</p>
            <p><strong>UF:</strong> {{ usuario.uf }}</p>
            <strong>Alergias:</strong>
            <ul>
              <li v-for="alergia in usuario.alergias" :key="alergia.id">
                {{ alergia.nome }}
              </li>
            </ul>
            <md-button
              @click="deleteUsuario(usuario.id)"
              class="md-raised md-danger"
            >
              <md-icon>delete</md-icon> Exlcuir {{ usuario.nome }}
            </md-button>
            <p><strong>Agendamentos:</strong></p>
            <md-table :table-header-color="tableHeaderColor">
              <md-table-row slot="md-table-row">
                <template>
                  <md-table-cell><strong>Data</strong></md-table-cell>
                  <md-table-cell><strong>Hora</strong></md-table-cell>
                  <md-table-cell><strong>Situação</strong></md-table-cell>
                  <md-table-cell><strong>Data Situação</strong></md-table-cell>
                  <md-table-cell><strong>Observações</strong></md-table-cell>
                  <md-table-cell><strong>Realizada</strong></md-table-cell>
                  <md-table-cell><strong>Cancelada</strong></md-table-cell>
                </template>
              </md-table-row>
              <md-table-row
                v-for="(item, index) in usuario.agendamentos"
                :key="index"
                slot="md-table-row"
              >
                <template>
                  <md-table-cell>{{ item.data }}</md-table-cell>
                  <md-table-cell>{{ item.hora }}</md-table-cell>
                  <md-table-cell>{{ item.situacao }}</md-table-cell>
                  <md-table-cell>{{ item.dataSituacao }}</md-table-cell>
                  <md-table-cell>{{ item.observacoes }}</md-table-cell>
                  <md-table-cell>
                    <md-checkbox
                      v-model="item.situacao"
                      :value="'Realizado'"
                      :disabled="
                        item.situacao === 'Cancelado' ||
                        item.situacao === 'Realizado'
                      "
                      @change="updateAgendamentoRealizado(item)"
                    ></md-checkbox>
                  </md-table-cell>
                  <md-table-cell>
                    <md-checkbox
                      v-model="item.situacao"
                      :value="'Cancelado'"
                      :disabled="
                        item.situacao === 'Cancelado' ||
                        item.situacao === 'Realizado'
                      "
                      @change="updateAgendamentoCancelado(item)"
                    ></md-checkbox>
                  </md-table-cell>
                </template>
              </md-table-row>
            </md-table>
          </md-card-content>
        </md-card>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  components: {},
  props: ["id"],
  created() {
    this.buscarUsuarioPorId();
  },
  data: () => ({
    usuario: {
      nome: "",
      dataNascimento: "",
      sexo: "",
      logradouro: "",
      numero: "",
      setor: "",
      cidade: "",
      uf: "",
      agendamentos: [],
    },
  }),
  methods: {
    async buscarUsuarioPorId() {
      const response = await this.$axios.get(
        `http://localhost:8080/usuario/${this.id}`
      );
      this.usuario = response.data;
      console.log(this.usuario);
    },
    async updateAgendamentoRealizado(item) {
      let observacao = window.prompt("Digite as observações");
      const response = await this.$axios.put(
        `http://localhost:8080/agenda/situacao?situacao=Realizado&id=${item.id}&observacoes=${observacao}`
      );
      this.buscarUsuarioPorId();
      this.notifyVue("top", "right");
    },
    async updateAgendamentoCancelado(item) {
      let observacao = window.prompt("Digite as observações");
      const response = await this.$axios.put(
        `http://localhost:8080/agenda/situacao?situacao=Cancelado&id=${item.id}&observacoes=${observacao}`
      );
      this.buscarUsuarioPorId();
      this.notifyVue("top", "right");
    },
    async deleteUsuario(id) {
      const response = await this.$axios.delete(
        `http://localhost:8080/usuario/${id}`
      );
      this.$router.push({ name: "visualizarUsuario" });
    },
  },
};
</script>
