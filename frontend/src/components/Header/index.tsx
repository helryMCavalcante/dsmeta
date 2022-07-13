import logo from '../../assets/img/iconHeader.svg'
import './style.css'
function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
            <img src={logo} alt="DATAMeta" />
            <h1>DATAMeta</h1>
            <p>
                Desenvolvido por
                <a href="https://github.com/helryMCavalcante"> HelryMCavalcante</a>
            </p>
        </div>
            </header >
    )
}

export default Header