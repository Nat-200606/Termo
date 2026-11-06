# 🟩 Termo

Versão do jogo **Termo** refeita para um trabalho da faculdade, com uma diferença: dá para jogar **infinitas vezes**, sem esperar a palavra do dia.

## 🎮 Como jogar

1. Descubra a palavra secreta em até 6 tentativas.
2. A cada tentativa, as letras mudam de cor:
   - 🟩 **Verde:** letra certa na posição certa
   - 🟨 **Amarelo:** a letra existe na palavra, mas em outra posição
   - ⬛ **Cinza:** a letra não existe na palavra
3. Terminou a rodada? Comece outra, quantas vezes quiser.

## ✨ Recursos

- Jogo ilimitado, com uma nova palavra sorteada a cada rodada
- Banco de palavras editável em `palavras.txt`
- Visual com fonte pixelada estilo Minecraft (`Minecraft.ttf`)

## 📁 Estrutura

```
Termo/
├── src/            # código-fonte do jogo
├── palavras.txt    # lista de palavras usadas nas rodadas
└── Minecraft.ttf   # fonte usada na interface
```

## ▶️ Como executar

```bash
# 1. Clone o repositório
git clone https://github.com/Nat-200606/Termo.git
cd Termo

# 2. Compile/execute (ajuste para a sua linguagem)
<comando para rodar o projeto>
```

> Requisitos: `<ex.: JDK 17+>`

## ➕ Adicionando palavras

Abra o `palavras.txt` e adicione uma palavra por linha, todas com o mesmo número de letras.

## 👩‍💻 Autora

Feito por [Nat-200606](https://github.com/Nat-200606) como projeto de faculdade.
